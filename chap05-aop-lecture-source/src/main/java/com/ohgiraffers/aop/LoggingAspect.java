package com.ohgiraffers.aop;

// 24-11-11 (월) 2교시, AOP (LoggingAspect 구성)
// 이 클래스의 할 일 : ⑭ 반복적인 일들을 이곳에 정의

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

import java.util.Map;

/* @Aspect 어노테이션 : AOP 기능을 사용하기 위한 어노테이션
 * → 사용하기 위해 Maven에서 다운 3가지 의존성 다운
 * Pointcut과 Advice를 하나의 클래스 단위로 정의하기 위한 어노테이션 */
@Aspect
@Component // 중간중간 빈들을 들어갔다 나왔다 해야하기 때문에 Component 어노테이션 적용
public class LoggingAspect {

    /* comment. @PointCut
     *   여러 조인 포인트를 매칭하기 위한 표현식
     *   사용식 : @PointCut("execution(수식어) returnType [클래스 명].이름(파라미터)")
     *   수식어란, public-private-protected-default 등의 접근제어자를 의미하며 생략 가능
     *   * → 와일드 카드(전부 가능하다는 의미) */

    @Pointcut("execution(* com.ohgiraffers.aop.*Service.*(..))") // 이 위치에서 실행하겠다.
    /* comment. ☆ 해석하기 ☆
        MemberService 뿐만 아니라 Service 앞에 뭐가 붙든, 다 허용 하겠다. ex) MenuService도 허용
         *Service → 이름이 Service로 끝내는 클래스 의미
         *Service.*(..) → 매개변수가 0개 이상인 모든 메서드
         *Service.*(*, ..) → 매개변수가 1개 이상인 모든 메서드 */

    public void logPointCut() {}

    /* comment. JoinPoint는 * com.ohgiraffers.aop.*Service.*(..)) 정보를 이미 갖고 있음.
     *   JoinPoint : 포인트 컷으로 설정한 실행 지점을 의미.
     *   실행 지점을 설정하게 되면 메서드 내에 작성한 코드(Advice)를
     *   어노테이션 종류에 따라 전,후,전후 등에 동작할 수 있게됨.
     *   메서드의 매개변수로 전달한 JoinPoint 객체는 현재 조인 포인트의
     *   메서드명, 인수, 정보 등을 가지고 있게 된다. */

    @Before("LoggingAspect.logPointCut()") // 지정한 위치 전에 동작함 (logpointcut() 메서드 전에 동작)
    public void logBefore(JoinPoint joinPoint) { // ⑮ 동작 순서 확인을 위한 타겟 정보 출력
        System.out.println("Before 타겟 정보 : " + joinPoint.getTarget());
        System.out.println("Before 타겟의 시그니처 : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) { // 매개변수(전달인자)의 개수 파악
            System.out.println("Before 타겟의 인자 : " + joinPoint.getArgs()[0]);
            // 전달인자가 있다면 출력
        }
    }

    // 3교시
    /* 같은 클래스 내에 PointCut 설정했다면 클래스명 생략 가능
        만약 다른 클래스에 PointCut 설정했다면 풀클래스명(패키지 포함)으로 작성해야 함! */
    @After("logPointCut()") // 해석 : 같은 클래스 내부에 있다면~ 나중에 동작시키겠다~
    public void logAfter(JoinPoint joinPoint) {
        System.out.println("after 타겟 정보 : " + joinPoint.getTarget());
        System.out.println("after 타겟의 시그니처 : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) { // 매개변수(전달인자)의 개수 파악
            System.out.println("after 타겟의 인자 : " + joinPoint.getArgs()[0]);
            // 전달인자가 있다면 출력
        }
    }

    /* comment. @AfterReturning 어노테이션
     *  return할 결과 값을 변경할 수 있다.
     *  <returning 속성>
     *  - 메서드가 동작 완료하고 자신을 호출한 쪽으로 가져가는 값.
     *  → 즉, 리턴값을 담아둘 변수명을 기술한다. */
    @AfterReturning(pointcut = "logPointCut()", returning = "result")
    public void logAfterReturning(JoinPoint joinPoint, Object result) { // result와 변수명 이름은 일치해야 함.
        // return되는 값(Map<Long, MemberDAO>)을 Object 타입으로 result라는 변수에 담음
        System.out.println("result 변수에 Service에서 return되는 값이 담겼는지 확인 : " + result);

        /* comment.
         *   result 변수에 Service 클래스에서 return 되는 값이 담긴 것 확인.
         *   → result 변수에 접근해서 값을 조작할 수 있다는 의미로 해석 */
        if (result != null && result instanceof Map) { // 값이 존재하거나, Map 타입이라면
            ((Map<Long, MemberDTO>) result).put(100L, new MemberDTO(100L, "반환되는 값 가공 성공."));
            // 100 추가되어 출력
        }
    }

    /* comment. @AfterThrowing
    *   이거로 크게 할 건 없음, 가볍게 넘기기 */
    @AfterThrowing(pointcut = "logPointCut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception) { // 이름 일치시키기
        System.out.println("AfterThrowing exception = " + exception);
    } // 예외 발생 시 출력 값 작성 (예를들어 잘못 된 값으로 호출 시)

    /* comment. @Around : (before + after) 실행 전 후 합친 것
        Around는 지정한 실행위치(JoinPoint) 앞 뒤를 모두 장악하고,
        타겟 메서드의 실행지점, 실행여부, 계속 진행 여부 등을 결정
        Around Advice는 JointPoint를 확장한 ProceedingJoinPoint를 매개변수로 받음. */
    @Around("logPointCut()") // AOP에서 가장 강력한 어노테이션
    public Object longArounc(ProceedingJoinPoint joinPoint) throws Throwable { // 반환형 : Object
        /* comment. 앞 뒤로 동작하게 되므로 소요되는 시간을 체크하는 로직 사용 */
        StopWatch stopWatch = new StopWatch();
        stopWatch.start(); // 시간 측정하는 스탑워치 실행
        System.out.println("Around Before 1 : " + joinPoint.getSignature().getName()); // 메서드 이름만 가져와보기.

        // Target 메서드 시작시키는 구문
        Object result = joinPoint.proceed(); // 출력 순서가 바뀌므로 함부로 사용하면 안 됨
        // 이 위에는 before , 아래는 after
        System.out.println("Around Before 2 : " + joinPoint.getSignature().getName()); // 메서드 이름만 가져와보기.

        stopWatch.stop(); // 스탑워치 멈추기

        System.out.println("메서드 실행에 소요된 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)");

        /* comment.
        *   조인 포인트를 호출한 쪽(지금은 Application) or 다른 어드바이스가 실행될 수 있도록
        *   Object 반환 */
        return result;
    }


}

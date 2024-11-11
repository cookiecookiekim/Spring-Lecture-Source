package com.ohgiraffers.aop;

// 24-11-11 (월) 2교시, AOP (LoggingAspect 구성)
// 이 클래스의 할 일 : ⑭ 반복적인 일들을 이곳에 정의

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/* @Aspect 어노테이션 : AOP 기능을 사용하기 위한 어노테이션
* → 사용하기 위해 Maven에서 다운 3가지 의존성 다운 */
@Aspect
@Component // 중간중간 빈들을 들어갔다 나왔다 해야하기 때문에 Component 어노테이션 적용
public class LoggingAspect {

    /* comment. @PointCut
    *   여러 조인 포인트를 매칭하기 위한 표현식
    *   사용식 : @PointCut("execution(수식어) returnType [클래스 명].이름(파라미터)")
    *   수식어란, public-private-protected-default 등의 접근제어자를 의미하며 생략 가능
    *   * → 와일드 카드(전부 가능하다는 의미) */

    @Pointcut("execution(* com.ohgiraffers.aop.*Service.*(..))")
    /* comment. ☆ 해석하기 ☆
        MemberService 뿐만 아니라 Service 앞에 뭐가 붙든, 다 허용 하겠다. ex) MenuService도 허용
         *Service → 이름이 Service로 끝내는 클래스 의미
         *Service.*(..) → 매개변수가 0개 이상인 모든 메서드
         *Service.*(*, ..) → 매개변수가 1개 이상인 모든 메서드 */
    public void logPointCut(){

    }

    /* comment.
    *   JoinPoint : 포인트 컷으로 설정한 실행 지점을 의미. */

    @Before("LoggingAspect.logPointCut()") // 지정한 위치 전에 동작함 (logpointcut() 메서드 전에 동작)
    public void logBefore(JoinPoint joinPoint){ // ⑮ 동작 순서 확인을 위한 타겟 정보 출력
        System.out.println("Before 타겟 정보 : " + joinPoint.getTarget());
        System.out.println("Before 타겟의 시그니처 : " + joinPoint.getSignature());
        if (joinPoint.getArgs().length > 0) { // 매개변수(전달인자)의 개수 파악
            System.out.println("Before 타겟의 인자 : " + joinPoint.getArgs()[0]);
            // 전달인자가 있다면 출력
        }
    }
}

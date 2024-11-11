package com.ohgiraffers.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-11 (월) 1교시, AOP (반복되는 코드 분리)
public class Application { // (컨트롤러 객체는 생략하기로)

    public static void main(String[] args) {

        ApplicationContext context      // ① 공장 구성
                = new AnnotationConfigApplicationContext(ContextConfig.class); // ⑤ 전달인자로 작성한 파일정보를 전달

        // ⑬ 서비스 호출을 위한 서비스 클래스 빈 꺼내오기
        MemberService memberService
                = context.getBean("memberService", MemberService.class);

        System.out.println("===============selectMembers================");
        System.out.println(memberService.selectMembers());
        System.out.println("===============selectMember================");
        System.out.println(memberService.selectMember(1L));


    }
}

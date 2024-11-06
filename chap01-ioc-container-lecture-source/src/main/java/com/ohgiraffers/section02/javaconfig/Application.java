package com.ohgiraffers.section02.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-06 (수) 2교시 스프링 자바 방식, 메인 클래스
public class Application {

    public static void main(String[] args) {

        /* index. 2. java 방식의 설정 */
        // java 방식이므로 xml 파일이 아닌 클래스 하나 생성
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);
                                        // bean 등록해놨던 클래스 정보 입력

        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member);
    }
}

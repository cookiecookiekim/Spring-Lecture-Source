package com.ohgiraffers.section01.xmlconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

// 24-11-06 (수) 1교시 스프링 xml 방식, 메인 클래스
public class Application {

    public static void main(String[] args) {

        /* index. 1. xml 방식으로 컨테이너 구성 */
        ApplicationContext context // xml 방식으로 spring의 상위 객체 공장 만들겠다.
           = new GenericXmlApplicationContext("section01/xmlconfig/spring-context.xml");
                // xml파일에 객체를 생성해 뒀으니, 여기에 생성위치를 풀 경로로 작성해줌

        // 담았으니, 꺼내서 사용해보기 (new 없어도 됨!)
        // 방식 1 : bean의 id를 통해 접근해보기 (객체 가져오기)
//        MemberDTO member = (MemberDTO) context.getBean("member"); // 일단 주석

        // 방식 2 :  bean의 클래스 정보를 전달하여 가져오는 방법
//        MemberDTO member = context.getBean(MemberDTO.class);

        // 방식 3 :
        MemberDTO member = context.getBean("member", MemberDTO.class);
        System.out.println("member = " + member); // 모두 동일하게 출력

        // 방식 1~3 모두 동일하게 출력 -> 오버로딩
    }
}

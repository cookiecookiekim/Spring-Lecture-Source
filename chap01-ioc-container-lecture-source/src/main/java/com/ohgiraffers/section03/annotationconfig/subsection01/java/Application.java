package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.common.MemberDAO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-06 (수) 3교시, 가장 많이 쓰는 방식인 annotation 방식
public class Application {

    public static void main(String[] args) {
        // 가장 많이 사용
        /* index. 3. Java-annotation 방식의 설정 */
        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);
        // 여기서 DAO 생성

        /* comment. @ComponentScan
        *   basePackage로 설정된 하위 경로에 특정 어노테이션을
        *   가지고 있는 클래스를 Bean으로 등록해주는 기능.
        *   특정 어노테이션은 @Component이며 특수한 목적에 따라서
        *   @Controller, @Service, @Repository(dao), @Configuration
        *   등을 사용한다. */

        // bean들을 꺼내기
        // getBeanDefinitionNames : 컨테이너에 생선된 bean 이름 반환
        String[] beanNames = context.getBeanDefinitionNames();
        for (String bean : beanNames){
            System.out.println("bean = " + bean);
            /* bean = org.springframework.context.annotation.internalConfigurationAnnotationProcessor
            bean = org.springframework.context.annotation.internalAutowiredAnnotationProcessor
            bean = org.springframework.context.event.internalEventListenerProcessor
            bean = org.springframework.context.event.internalEventListenerFactory
            bean = configuration03
            bean = memberDAO
            bean = configuration02
            bean = member */ // @ComponentScan.Filter 시, 출력 제외되는 것들 확인
        }
        // bean 등록 돼있는
        MemberDAO memberDAO = context.getBean("memberDAO", MemberDAO.class);
        System.out.println(memberDAO.selectMember(1));
        // MemberDTO(no=1, id=user01, pwd=pass01, name=김규남) 출력

    }
}

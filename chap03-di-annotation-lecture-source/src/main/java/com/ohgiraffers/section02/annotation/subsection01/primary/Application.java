package com.ohgiraffers.section02.annotation.subsection01.primary;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-07 (목) 3교시 ①
public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        // ⑨ 출력 전, 빈의 종류 확인
        String [] beanName = context.getBeanDefinitionNames();
        for (String bean : beanName) {
            System.out.println("bean = " + bean);
            // 인터페이스에 3개의 클래스가 상속받고 있으므로, 에러 발생
            // ⑩ koala에 Primary 지정하여 순서 설정 → 에러 발생하지 않음
        }
        AnimalService animalService
                = context.getBean("primaryService", AnimalService.class);
        animalService.animalEat(); // ⑪ Primary 지정한 koala 메서드가 실행
    }
}

package com.ohgiraffers.section02.annotation.subsection03.collection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-07 (목) 3교시 ① primary package 복붙
public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext("com.ohgiraffers.section02");

        //
        String [] beanName = context.getBeanDefinitionNames();
        for (String bean : beanName) {
            System.out.println("bean = " + bean);
            //
        }
        AnimalService animalService
                = context.getBean("collectionService", AnimalService.class);
        animalService.animalEat(); // 
    }
}

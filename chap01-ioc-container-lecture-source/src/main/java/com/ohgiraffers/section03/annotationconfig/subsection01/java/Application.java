package com.ohgiraffers.section03.annotationconfig.subsection01.java;

import com.ohgiraffers.section02.javaconfig.ContextConfiguration;
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

    }
}

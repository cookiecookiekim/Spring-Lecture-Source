package com.ohgiraffers.aop;

// 24-11-11 (월) 1교시, AOP

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // ③ 이 클래스는 Configuration 파일이다.
@ComponentScan("com.ohgiraffers.aop") // ④ aop 페키지 내에 빈으로 등록한 어노테이션들 스캔하겠다.
public class ContextConfig {
}

package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

// 24-11-08 (금) 2교시 , annotation 방식의 init : 생성 destroy : 파괴
// ② bean들을 정의할 Configuration 클래스

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
// Owner에 Component 달아 놨으니, scan 필요
@ComponentScan("com.ohgiraffers.section02.initdestroy.subsection02.annotation")// basepackage 설정
public class ContextConfig {

    // ⑧ Bean 등록하기
    @Bean
    public Product kimchi(){
        return new Food("겉절이", 2000, new Date());
    }

    @Bean
    public Product coke(){
        return new Drink("콜라", 1500, 500);
    }

    @Bean
    public Product soda(){
        return new Drink("밀키스", 1800, 250);
    }

    @Bean
    @Scope("prototype")
    public Cart cart(){ return new Cart(); }



}

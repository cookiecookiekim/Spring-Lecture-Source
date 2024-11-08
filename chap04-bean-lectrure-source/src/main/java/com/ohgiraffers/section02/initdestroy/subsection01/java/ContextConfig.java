package com.ohgiraffers.section02.initdestroy.subsection01.java;

// 24-11-08 (금) 2교시 , 자바 방식의 init : 생성 destroy : 파괴
// ② bean들을 정의할 Configuration 클래스

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.Date;

@Configuration
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
    public Cart cart(){
        return new Cart();
    }


    // ③ Owner 클래스 사용하기 위한 Bean 등록
    @Bean(initMethod = "openShop", destroyMethod = "closeShop") // init,destroy 메서드 설정
    // initMethod는 run과 동시에 최초 동작함.
    public Owner owner(){
        return new Owner();
    }

}

package com.ohgiraffers.section01.scope.subsection01.singleton;

// 24-11-08 (금) 1교시 bean의 생명주기
// ② bean들을 정의할 Configuration 클래스

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    // 상품을 담기 위한 카트 객체 생성
    public Cart cart(){
        return new Cart();
    }

}

package com.ohgiraffers.section01.scope.subsection02.prototype;

// 24-11-08 (금) 2교시 싱글톤 - bean 누적 출력 해결하기
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
    /* comment. 싱글톤 - bean 해결방법
    *   @Bean의 기본 DefaultScope는 Singleton이다.
    *   prototype이라는 문자열을 @Scope어노테이션에
    *   전달하면, getBean으로 객체 꺼낼 때마다
    *   새로운 인스턴스를 생성하게 된다!!*/
    @Scope("prototype") // 2교시, 싱글톤 bean 해결 : @Scope에 prototype 전달함
    // 상품을 담기 위한 카트 객체 생성
    public Cart cart(){
        return new Cart();
    }

}

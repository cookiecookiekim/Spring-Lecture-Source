package com.ohgiraffers.section03.properties.subsection01.properties;

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Product;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import java.util.Date;


// 24-11-08(금) 3교시, bean 등록을 위한 클래스 생성
@Configuration
/* ④ resource 폴더에 작성해둔 파일을 읽어들이는 annotation */
@PropertySource("section03/properties/product-info.properties") // ⑤ 프로퍼티 파일 경로 기술
public class ContextConfig {

    /* comment. @PropertySource
     *   읽을 파일에 경로를 지정하면 프로퍼티 파일에
     *   작성한 데이터를 읽을 준비가 된 것.
     *   값 읽어들일 때, key와 value에 접근하며,
     *   @Value 어노테이션을 사용해 간단히 불러올 수 있음. */

    // lombok 제공이 아닌, spring 프레임워크로 임포트
    @Value("${food.kimchi.name}") // @Value 사용법 : "${key}"
    private String foodName; // value인 kimchi를 foodName이라는 변수에 담아놓은 개념

    @Value("${food.kimch.price}")
    private int foodPrice;

    @Value("{drink.coke.name}")
    private String drinkCoke;

    @Value("{drink.coke.price}")
    private int drinkCokePrice;

    @Value("${drink.coke.capacity}")
    private int cokeCapacity;

    @Value("${drink.soda.name}")
    private String drinkSoda;

    @Value("${drink.soda.price}")
    private int drinkSodaPrice;

    @Value("${drink.soda.capacity}")
    private int sodaCapacity;

    // key 설정했으니, Bean 생성
    @Bean
    public Product coke(){
        return new Drink(drinkCoke,drinkCokePrice,cokeCapacity);
    }
    @Bean
    public Product soda(){
        return new Drink(drinkSoda,drinkSodaPrice,sodaCapacity);
    }
    @Bean
    public Product kimchi(){
        return new Drink(foodName,foodPrice,new Date());
    }
    @Bean
    @Scope("prototype")
    public Cart cart(){
        return new Cart();
    }

    // 중요 파일을 properties에 넣어 놨기 때문에 유출의 안정성 있음.
}

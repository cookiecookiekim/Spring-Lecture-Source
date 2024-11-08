package com.ohgiraffers.section01.scope.subsection02.prototype;

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-08 (금) 2교시 bean의 생명주기 , 싱글톤 bean 해결해보기
public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfig.class);
                                           // ③ ContextConfig.class 정보 넘겨주기

        String [] beanNames = context.getBeanDefinitionNames();
        for (String bean : beanNames) {
            System.out.println("bean = " + bean); // ⑨ bean들이 컨테이너에 잘 등록했는지 확인하기
        }

        // ⑩ 빈들 꺼내보기
        Product kimchi = context.getBean("kimchi", Food.class);
        Product coke = context.getBean("coke", Drink.class);
        Product soda = context.getBean("soda", Drink.class);

        // 카트 객채 꺼내보기
        // ⑪ 첫 번째 손님을 위한 쇼핑카트 객체 생성
        Cart cart1 = context.getBean("cart", Cart.class);
        cart1.addItem(kimchi);
        cart1.addItem(soda);

        System.out.println("첫 번째 손님 카트 목록 : " + cart1.showCart());
// 첫 번째 손님 카트 목록 : [Product(name=겉절이, price=2000)Fri Nov 08 10:34:29 KST 2024, Product(name=밀키스, price=1800)250]

        // ⑫ 두 번째 손님을 위한 쇼핑카트 객체 생성
        Cart cart2 = context.getBean("cart", Cart.class);
        cart2.addItem(coke);
        System.out.println("두 번째 손님 카트 목록 : " + cart2.showCart());
        // subsection1과 다르게, 첫번 째 손님과 다른 카트에 담겨 출력.

        System.out.println("cart1 : " + cart1.hashCode());
        System.out.println("cart2 : " + cart2.hashCode()); // 1과 2의 hashCode가 상이
        // 문제 해결!

    }
}

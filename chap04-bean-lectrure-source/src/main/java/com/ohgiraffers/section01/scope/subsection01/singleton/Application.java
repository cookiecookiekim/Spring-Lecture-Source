package com.ohgiraffers.section01.scope.subsection01.singleton;

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-08 (금) 1교시 bean의 생명주기
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
        // 첫번째 손님의 카트 목록에 coke 가 추가되어 출력 → 따로 담길 줄 알았지만 하나의 인스턴스여서 함께 출력

        System.out.println("cart1 : " + cart1.hashCode());
        System.out.println("cart2 : " + cart2.hashCode()); // 1과 2의 hashCode가 동일
        // 이유 : 아래 comment 참고


        /* comment.
        *   Spring 프레임워크에서 Bean(객체)의 기본 scope는 Singleton이다.
        *   Bean 등록 시, 하나의 인스턴스만 생성하여 공유 및 사용한다.
        *   → 설정 파일을 Bean으로 등록하고, 그 이외에 행위 위주를 bean으로 등록한다. */

        // bean 사용시 싱글톤에 의한 값 누적을 해결하기 → subsection02 - prototype
    }
}

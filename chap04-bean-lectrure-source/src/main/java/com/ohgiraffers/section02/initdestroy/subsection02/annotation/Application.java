package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import com.ohgiraffers.common.Cart;
import com.ohgiraffers.common.Drink;
import com.ohgiraffers.common.Food;
import com.ohgiraffers.common.Product;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// 24-11-08 (금) 2교시 , annotation 방식의 init : 생성 destroy : 파괴
public class Application {

    public static void main(String[] args) {

        ApplicationContext context
                = new AnnotationConfigApplicationContext(ContextConfig.class);

        String [] beanNames = context.getBeanDefinitionNames();
        for (String bean : beanNames) {
            System.out.println("bean = " + bean);
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

        System.out.println("=============section02-subsection01-java====================");
        // initmethod 등록 후 run 시 최초 동작
        /* comment.
        *   init 메서드는 Bean 객체 생성 시점에 동작한다.
        *   destroy 메서드는 Bean 객체 소멸 시점에 동작하게 되는데
        *   이는 컨테이너를 종료시키지 않으면 확인할 수 없다.
        *   가비지 컬렉터가 해당 빈을 메모리에서 삭제할 때 destroy 메서드가
        *   동작하게 되는데 메모리에서 지우기 전에 프로세스가 종료되기 때문에
        *   강제로 컨테이너를 닫아줘야 destroy 확인이 가능하다. */

        // destroy는 굳이 알 필요는 없지만, 닫는 방법은 아래 확인
        ((AnnotationConfigApplicationContext)context).close();
        // close 등록 후, run 시, 맨 마지막에 destroy 메서드 동작

        System.out.println("=============section02-subsection02-annotation====================");
        //  @PostConstruct , @Predestroy 의존성 주입 후 run시, 잘 동작
    }
}

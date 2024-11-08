package com.ohgiraffers.common;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

// ⑤ 제품 상속 받는 클래스
// 생성자는 만들었으니, 게터세터 생성 (투스트링은 수동 추가)
@Getter
@Setter
public class Drink extends Product {

    private int capacity; // 음료수 용량 (ml)

    // rombok 사용하지 않고 기본생성자 생성
    public Drink (String foodName, int foodPrice, Date date) {
        super(); // 부모의 기본생성자 호출하겠다.
    }

    // 모든 필드 초기화하는 생성자 생성
    public Drink(String name, int price, int capacity) {
        super(name, price); // 부모의 것(Product)을 인용하여 초기화
        this.capacity = capacity;
    }

    @Override
    public String toString () {
        // 부모의 toString 메서드 가져오면서 내 필드를 출력할 수 있는 구문 추가
        return super.toString() + "" + this.capacity;
    }

}

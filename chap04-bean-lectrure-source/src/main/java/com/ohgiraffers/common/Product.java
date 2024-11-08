package com.ohgiraffers.common;

import lombok.*;

// ④ 부모 DTO 클래스 (Drink와 Food 상속해줌)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    private String name; // 상품명
    private int price; // 상품 가격
}

package com.ohgiraffers.common;

import java.util.ArrayList;
import java.util.List;

// ⑦ 쇼핑카트. (제품 골라서 담는 클래스)
public class Cart {

    private final List<Product> items; // 카트에 담긴 상품들 (쇼핑한 Product들을 담기 때문에 List)

    public Cart(){
        items = new ArrayList<>();
    }

    // 전달 받은 상품을 카트에 담는 메서드
    public void addItem(Product item) { // 상품 하나 전달 받아서, items에 add 하는 메서드
        items.add(item);
    }

    // 카트에 담긴 물품 확인 메서드
    public List<Product> showCart(){
        return items;
    }

}

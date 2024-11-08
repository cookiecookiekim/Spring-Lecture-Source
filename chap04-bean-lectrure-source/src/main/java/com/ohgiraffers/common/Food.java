package com.ohgiraffers.common;

import java.util.Date;

// ⑥ 생산 시간만 가질 수 있는 클래스 생성
public class Food extends Product {

    private Date backedDate; // 음식 만들어지는 시간

    public Food(){ super();}

    public Food(String name, int price, Date backedDate){
        super(name,price);
        this.backedDate = backedDate;
    }

    @Override
    public String toString () {
        // 부모의 toString 메서드 가져오면서 내 필드를 출력할 수 있는 구문 추가
        return super.toString() + "" + this.backedDate;
    }
}

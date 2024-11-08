package com.ohgiraffers.section02.initdestroy.subsection01.java;

// ① 쇼핑몰 주인 클래스 생성
public class Owner {

    public void openShop(){
        System.out.println("사장님이 가게 문을 열었습니다. 쇼핑이 가능합니다.");
    }

    public void closeShop(){
        System.out.println("사장님이 가게 문을 닫았습니다. 안녕히 가세요.");
    }
    // ② 이 메서드들을 사용하기위해 bean으로써 등록 → ContextConfig로..
}

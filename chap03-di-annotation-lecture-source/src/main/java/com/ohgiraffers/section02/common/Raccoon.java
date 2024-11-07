package com.ohgiraffers.section02.common;

// 24-11-07 (목) 3교시, ③ 인터페이스의 메서드를 실제 동작시킬 클래스 생성

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // ④ 컴포넌트 설정
@Primary
public class Raccoon implements Animal {

    @Override
    public void eat() {

        System.out.println("너구리가 이탈리안BLT를 먹어요.");
    }
}

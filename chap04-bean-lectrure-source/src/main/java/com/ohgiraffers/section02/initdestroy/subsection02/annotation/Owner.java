package com.ohgiraffers.section02.initdestroy.subsection02.annotation;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Component;

// ① annotation 방식의 init , destroy
// 행위 위주의 방식이기 때문에 Owner에 직접 어노테이션 등록
@Component
public class Owner {

    @PostConstruct // 생성되기 전에 동작 (= init-method를 뜻함)
    // 라이브러리 받아야 사용 가능 (노션 확인)
    public void openShop(){
        System.out.println("사장님이 가게 문을 열었습니다. 쇼핑이 가능합니다.");
    }

    @PreDestroy // 파괴되기 이전에 동작 (= destroy-method를 뜻함)
    // 라이브러리 받아야 사용 가능 (노션 확인)
    public void closeShop(){
        System.out.println("사장님이 가게 문을 닫았습니다. 안녕히 가세요.");
    }
}

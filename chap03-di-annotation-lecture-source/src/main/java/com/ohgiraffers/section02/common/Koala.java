package com.ohgiraffers.section02.common;

// 24-11-07 (목) 3교시, ③ 인터페이스의 메서드를 실제 동작시킬 클래스 생성

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component // ④ 컴포넌트 설정
//@Primary // ⑩ 우선순위 지정 (단 한 개만 우선순위로 설정해야 함)
/* ⑫ comment. @Primary 어노테이션
*     @Autowired로 동일한 타입(Animal)의 여러 Bean을
*     찾게되는 경우, 자동으로 연결을 우선시 할 타입으로 설정
*     동일한 타입의 클래스중 한 개만 @Primary 어노테이션을
*     사용할 수 있다. */
public class Koala implements Animal {

    @Override
    public void eat() {
        System.out.println("코알라가 나뭇잎을 먹어요.");
    }
}

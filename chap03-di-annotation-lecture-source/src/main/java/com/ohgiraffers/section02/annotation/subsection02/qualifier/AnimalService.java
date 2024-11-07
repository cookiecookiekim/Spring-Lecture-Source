package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

// 24-11-07 (목) 3교시, ② 서비스 클래스 생성
@Service("qualifierService")
public class AnimalService {

    //

    /* comment. @Qualifier 어노테이션
    *   여러개의 Bean 객체 중에서 특정 Bean을 이름으로
    *   지정하는 어노테이션.
    *   @Primary 어노테이션이 존재하더라도 Qualifier로
    *   이름 지정을 해두면, 우선순위를 가지게 됨. */

    /* ③ 필드 주입 방식으로 해보기 */
    @Autowired
//    @Qualifier("raccoon")  // 필드 방식은 안 쓰니까 주석
    private final Animal animal;

    @Autowired // ⑦
    public AnimalService(@Qualifier("raccoon") Animal animal){ // ④ 라쿤을 우선순위로 두겠다.
        this.animal = animal;
    }

    public void animalEat(){ //
        animal.eat();
    }
}

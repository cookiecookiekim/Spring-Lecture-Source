package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

// 24-11-07 (목) 3교시, ⑤ 서비스 클래스 생성
@Service("primaryService")
public class AnimalService {

    // ⑥ 생성자 주입으로 작성
    private final Animal animal;

    /* 생성자가 한 개라면 @Autowired 어노테이션을 생략해도
    *   알아서 의존성을 주입해준다. */
    @Autowired // ⑦ 어노테이션 설정
    public AnimalService(Animal animal){
        this.animal = animal;
    }

    public void animalEat(){ // ⑧ 메서드 추가
        animal.eat();
    }
}

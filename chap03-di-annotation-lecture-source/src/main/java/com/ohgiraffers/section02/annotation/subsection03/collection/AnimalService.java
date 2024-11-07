package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Animal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 24-11-07 (목) 3교시, ② 서비스 클래스 생성
@Service("collectionService")
public class AnimalService {

    private final List<Animal> animals;

    @Autowired // ① 생성자를 통한 의존성 주입
    public AnimalService(List<Animal> animals){
        this.animals = animals;
    }

    public void animalEat(){ // ③ eat 메서드 3번 호출해야 하므로 반복문으로
        for (Animal animal : animals) {
            animal.eat();
        }
    }
}

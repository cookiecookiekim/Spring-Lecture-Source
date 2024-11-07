package com.ohgiraffers.section01.common;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.*;

// 24-11-07 (목) 1교시, ③ 인터페이스의 기능을 구현할 클래스 생성

// ⑥ 상속 받은 BookDAOimpl를 bean 등록
// @Component
// @Component 역할에 따라 특수한 @Repository 어노테이션
@Repository("bookDAO")// 컴포넌트보다 세분화된 어노테이션으로 등록
// DB에 접근용 어노테이션. (DAO의 역할)
public class BookDAOimpl implements BookDAO {

    private final Map<Integer,BookDTO> bookList;
    /* ↑ DB 연동은 생략하고 생성자를 통한 임시 데이터 생성 ↑ */

    public BookDAOimpl(){ // 임시 데이터를 만들었다 라고 생각.
        // ④ 생성자를 통해 값 넣기.
        bookList = new HashMap<>();
        bookList.put(1, new BookDTO(1, 1234, "자바가 제일 쉬웠어요!", "김규남", "하이출판",new Date()));
        bookList.put(2, new BookDTO(2, 4321, "자바가 제일 어려웠어요!", "김규순", "바이출판",new Date()));
    }

    // ⑤ return 구문 수정
    @Override
    public List<BookDTO> selectBookList() {
        return new ArrayList<>(bookList.values());
    }

    @Override
    public BookDTO selectBookByNo(int no) {
        return bookList.get(no);
    }
}

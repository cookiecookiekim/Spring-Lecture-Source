package com.ohgiraffers.section01.common;

import java.util.List;

// 24-11-07 (목) 1교시, ③ DAO 생성 (공통적인 기능 작성)
public interface BookDAO {

    /* 도서 목록 전체 조회 */
    List<BookDTO> selectBookList(); // 전체 조회니까 List로 생성하고, BookDTO로 한정

    /* 도서 번호로 도서 조회 */
    BookDTO selectBookByNo(int no);

    // ③ 이 기능들을 구성할 클래스 생성 → BookDAOimpl
}

package com.ohgiraffers.section01.autowired.subsection02.constructor;

// 24-11-07 (목) 2교시 ② 서비스 클래스 생성

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOimpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("constructorService") // ③ 빈 등록
public class BookService {

    /* comment. ⑦
    *   1. 필드 주입은 의존성이 있는 객체가 생성되지 않아도
    *   객체 생성이 가능하다.
    *   따라서 메서드가 호출될 때(런타임) 에러가 발생됨.
    *   생성자 주입은 의존성이 있는 객체가 생성되지 않으면
    *   객체의 생성 자체가 불가능하며 컴파일 에러가 발생한다.
    *   2. 필드에 final 키워드를 쓸 수 있기 떄문에 객체 생성
    *   이후, 의존성을 변경할 수 없어, 안정성을 보장한다. */

    private final BookDAO bookDAO; // ⑥ final 안 적을시 @Autowired 안에서 new 사용 됨
    // new 남발을 막기 위해서는 final 기입

    @Autowired // ⑤ Autowired 등록 , 메서드 작성
    public BookService(BookDAO bookDAO) { // ④ 기본 생성자 생성
        this.bookDAO = bookDAO;
    }

    public List<BookDTO> selectAllBooks(){

//        bookDAO = new BookDAOimpl(); // new 키워드가 사용 가능하게됨 → 안정성이 떨어짐.
                                    // new 사용 못하게 final로 막아줘야함.

        return bookDAO.selectBookList();
    }

    public BookDTO selectOneBook(int no){
        return bookDAO.selectBookByNo(no);
    }

}

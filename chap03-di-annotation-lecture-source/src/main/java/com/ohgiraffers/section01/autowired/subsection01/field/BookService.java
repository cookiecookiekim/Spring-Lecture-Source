package com.ohgiraffers.section01.autowired.subsection01.field;

import com.ohgiraffers.section01.common.BookDAO;
import com.ohgiraffers.section01.common.BookDAOimpl;
import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 24-11-07 (목) 2교시, ⑦ DAO에 있는 메서드 호출하기 위한 클래스

// @Component 어노테이션의 세분화된 @Service
// Service 계층에서 사용
@Service(value="fieldService") // ⑧ @Service 등록, 해당 클래스를 사용할 이름 등록
public class BookService {

    // private BookDAO bookDAO = new BookDAOImpl(); 원래대로라면
    // 이렇게 객체 생성하고 메서드 호출 했었음.

    // 필드 방식으로 관계를 생성
    @Autowired // ⑨ 필드 방식으로 의존성 주입
                // 필드 방식의 단점 : new라는 키워드를 사용할 수 있게됨.

    private BookDAO bookDAO; // 인터페이스의 BookDAO (구현 은닉[난이도 높음] 알고 넘어가면 좋음)

    /* 전체 조회 기능 호출 */
    public List<BookDTO> selectAllBooks(){
        /* comment. Spring에서의 의존성 주입
        *   미리 Bean으로 컨테이너에 등록해둔 객체를 필요 시에
        *   @Autowired 어노테이션으로 가져다 쓰는 개념.
        *   따라서 개발자는 new 키워드로 객체를 생성하는 게 아닌
        *   컨테이너에 존재하는 객체를 가져와야 함. */

//      ⑩ bookDAO = new BookDAOimpl(); // 이런 식으로 new 사용이 가능하게됨
        // 필드 주입의 단점 : 새로운 객체를 new로 덮어 쓰이게 됨

        return bookDAO.selectBookList();
    }

    /* 번호로 책 한 권 조회 기능 호출 */
    public BookDTO selectOneBook(int no) {
        return bookDAO.selectBookByNo(no);
    }

}

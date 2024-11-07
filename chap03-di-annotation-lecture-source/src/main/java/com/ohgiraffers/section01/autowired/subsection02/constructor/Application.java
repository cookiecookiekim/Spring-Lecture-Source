package com.ohgiraffers.section01.autowired.subsection02.constructor;

import com.ohgiraffers.section01.common.BookDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

// 24-11-07 (목) 2교시 ① Application 생성 (field app 복붙)
public class Application {

    public static void main(String[] args) {

        /* index. 2. 생성자 주입(2) - 생성자 */
        /* comment. @Autowired 어노테이션
        *   객체와 객체간의 의존성을 생성할 때 대표적인 어노테이션.
        *   1. 필드 주입 (사용 빈도 : SI 업체 20% , 특징 : 간결)
        *   2. 생성자 주입 (사용 빈도 : 79%)
        *   3. setter 주입 (사용 빈도 : 1%, 거의 안 씀) */

        // 클래스를 전달해도 되지만 문자열 전달 시, 문자열이 곧 Bean을 스캔할 컴포넌트 스캔 범위가 됨.
        ApplicationContext context = // 컨태이너 생성
                new AnnotationConfigApplicationContext("com.ohgiraffers.section01");
        // → com.ohgiraffers.section01 내에 있는 모든 컴포넌트 스캔

        BookService service = context.getBean("constructorService", BookService.class); // 임포트 확인

        List<BookDTO> bookList = service.selectAllBooks();
        for (BookDTO book : bookList) {
            System.out.println("book = " + book);
        }
        System.out.println(service.selectOneBook(1)); // ⑧ no 값으로 조회해보기
    }
}

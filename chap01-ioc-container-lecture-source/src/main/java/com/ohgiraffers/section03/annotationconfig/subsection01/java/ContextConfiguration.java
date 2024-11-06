package com.ohgiraffers.section03.annotationconfig.subsection01.java;

// 24-11-06 (수) section02 클래스 복붙

import com.ohgiraffers.common.MemberDAO;
import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

// ★ @Configuration이 Component 어노테이션을 수집해야 Component 를 bean으로 등록할 수 있음!!!! ★
@Configuration("configuration03")

// 스캔을 통해서 Component를 찾아서, bean으로 등록!!
/* test 1 basePackages */
//@ComponentScan(basePackages = "com.ohgiraffers")
/* test 2 basePackages 안에서 제외하고 싶은 애들 설정*/
@ComponentScan(basePackages = "com.ohgiraffers",
    excludeFilters = { // {}로 값을 여러개 넘길 수 있다. // 잘 안 씀, 흐름만
        @ComponentScan.Filter( // filter로 거르겠다
                /* 1. 타입으로 설정 */
//                type = FilterType.ASSIGNABLE_TYPE
//                ,classes = {MemberDAO.class} // DAO를 bean으로 등록하지 않겠따...
                /* 2. 어노테이션 종류로 설정 */
//                type = FilterType.ANNOTATION
//                ,classes = {org.springframework.stereotype.Component.class}
                /* 3. 표현식으로 설정 */
//                type = FilterType.REGEX // 출력 잘 안 됨. 이상함.
//                ,pattern = {"com.ohgiraffers.section03.annotationconfig.subsection01.java.*"}
        )
    }
)
// basePackages(경로 지정) → com.ohgiraffers 하위 페키지 스캔하겠다.


public class ContextConfiguration {


}

package com.ohgiraffers.section02.javaconfig;

// 24-11-06 (수) 2교시 스프링 자바 방식 설정을 위한 클래스

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/* comment. @Configuration 어노테이션 해당 클래스가
*   빈을 생성하는 클래스임을 컨테이너에게 알려준다. */
@Configuration("configuration02") // 이와 같이 이름도 붙일 수 있음.
public class ContextConfiguration {

    /* 1명의 회원을 Bean 등록해보기 */
    /* comment. @Bean 어노테이션은 해당 메서드의 반환값을
    *       컨테이너에 Bean(객체)로 등록하겠다는 의미.
    *       이름을 별도로 지정하지 않으면, 메서드 이름을 id로 인식 */
    @Bean(name = "member") // "member" 라는 id 설정
    public MemberDTO getMember() {
        // 만약 "member"라는 id 없다면 메서드명인 getMember가 id
        return new MemberDTO(2, "user02", "pass02", "김기남");
    }

}

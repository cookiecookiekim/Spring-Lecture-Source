package com.ohgiraffers.common;

import lombok.*;

// 24-11-06 (수) 스프링, DTO 구성
//하위 @는 lombok 의존으로 생성
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
// @Data → 위에 5가지를 수행할 수 있지만 lombok 자체의 버그가 많아 권장 X
public class MemberDTO {

    private int no;
    private String id;
    private String pwd;
    private String name;

}
// 위와 같이 필드만 작성하면 getter , setter 작성 안 해도 사용 가능

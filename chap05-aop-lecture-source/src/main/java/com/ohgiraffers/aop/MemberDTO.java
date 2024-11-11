package com.ohgiraffers.aop;

import lombok.*;

// 24-11-11 (월) 1교시, AOP (⑥ DTO 구성)
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MemberDTO {

    private Long no; // 회원번호
    private String name; // 회원이름

}

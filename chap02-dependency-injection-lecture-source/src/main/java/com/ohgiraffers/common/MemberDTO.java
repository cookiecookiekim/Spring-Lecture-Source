package com.ohgiraffers.common;

import lombok.*;

// // 24-11-06 (수) 4교시, MemberDTO 생성
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberDTO {

    private int no;
    private String name;
    private String email;
    private Account personalAccount; // 계좌

}

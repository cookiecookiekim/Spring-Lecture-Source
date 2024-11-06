package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.MemberDTO;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application { // 메인 클래스

    public static void main(String[] args) {

        ApplicationContext context // 자바 방식으로 설정
                = new AnnotationConfigApplicationContext(ContextConfiguration.class);

        MemberDTO member = context.getBean(MemberDTO.class); // 클래스 정보 전달
        System.out.println(member.getPersonalAccount()); // 멤버가 가지고 있는 계인 계좌
// PersonalAcoount(bankCode=20, accNo=1002-051-054-123, balance=1002-051-054-123계좌의 잔액은 0원 입니다.)
        System.out.println(member.getPersonalAccount().deposit(10000));
        // 10000원이 입금 되었습니다.
        System.out.println(member.getPersonalAccount().getBalance());
        // 1002-051-054-123계좌의 잔액은 10000원 입니다.

        System.out.println(member.getPersonalAccount().withDraw(5000));
        // 5000원이 출금 되었습니다.
        System.out.println(member.getPersonalAccount().getBalance());
        // 1002-051-054-123계좌의 잔액은 5000원 입니다.
    }
}

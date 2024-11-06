package com.ohgiraffers.common;

// 24-11-06 (수) 4교시, Account 인터페이스 생성
// interface 생성 이유 : 강제화, 인터페이스에 정의해 놓은 것들은
// 실제 사용은 안 하더라도 다른 곳에서 implements 상속 받고, 구현은 해둬야 한다.
public interface Account {

    // 잔액 조회
    String getBalance();

    // 입금
    String deposit(int money);

    // 출금
    String withDraw(int money);

}

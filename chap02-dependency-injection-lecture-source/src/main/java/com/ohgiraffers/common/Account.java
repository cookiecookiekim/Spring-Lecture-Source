package com.ohgiraffers.common;

// 24-11-06 (수) 4교시, Account 인터페이스 생성
public interface Account {

    // 잔액 조회
    String getBalance();

    // 입금
    String deposit(int money);

    // 출금
    String withDraw(int money);

}

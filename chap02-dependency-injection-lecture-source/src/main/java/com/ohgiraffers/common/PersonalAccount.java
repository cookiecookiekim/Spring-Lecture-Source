package com.ohgiraffers.common;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

// 24-11-06 (수) 4교시, 의존성
@Getter
@Setter
@ToString
public class PersonalAccount implements Account { // Account 상속 받기
    // 강제로 3가지 메서드 오버라이딩해야 상속 가능 (오류 안 남)
    private final int bankCode; // 은행 코드
    private final String accNo; // 계좌번호
    private int balance;        // 잔액

    // 생성자를 통한 초기화
    public PersonalAccount(int bankCode, String accNo){
        this.bankCode = bankCode;
        this.accNo = accNo;
    }

    @Override
    public String getBalance() {
        return this.accNo + "계좌의 잔액은 " + this.balance + "원 입니다.";
    }

    @Override
    public String deposit(int money) {
        String str = "";
        if (money >= 0) {
            this.balance += money;
            str = money + "원이 입금 되었습니다.";
        } else {
            str = "잘못된 금액입니다.";
        }
        return str;
    }

    @Override
    public String withDraw(int money) {

        String str = "";
        if (this.balance >= money){
            this.balance -= money;
            str = money + "원이 출금 되었습니다.";
        } else {
            str = "잔액이 부족합니다";
        }
        return str;
    }
}

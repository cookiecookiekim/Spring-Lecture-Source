package com.ohgiraffers.aop;

import org.springframework.stereotype.Service;

import java.util.Map;

// 24-11-11 월 1교시 ⑩ 서비스 클래스 생성
@Service
public class MemberService { // 다른 클래스와 다른 클래스 연결하려면 의존성 주입이 필요

    private final MemberDAO memberDAO;

    /* 생성자 주입으로 Bean들과의 의존성 생성 */
    public MemberService() {
        this.memberDAO = new MemberDAO();
    }

    // ⑪ 전체조회하는 DAO 로직 호출 구문
    public Map<Long, MemberDTO> selectMembers(){
        System.out.println("selectMembers 메서드 실행됨...");
        return memberDAO.selectAllMembers();
    }

    // ⑫ 회원 번호로 조회하는 DAO 로직 호출 구문
    public MemberDTO selectMember(Long no) {
        System.out.println("selectMember 메서드 실행됨...");
        return memberDAO.selectMemberByNo(no);
    }
}

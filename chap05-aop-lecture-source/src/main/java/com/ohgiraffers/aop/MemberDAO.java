package com.ohgiraffers.aop;

// 24-11-11 (월) 1교시 ⑦ Repository 구성
// DB 접촉 전 마지막 단계

import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class MemberDAO {

    /* 아직 DB 접속은 하지 않을 것이기 때문에 임시 DB 생성 */
    private final Map<Long, MemberDTO> memberMap;

    public MemberDAO(){ // ⑧ 빈으로써 인식될 때 데이터 생성
        memberMap = new HashMap<>();
        memberMap.put(1L, new MemberDTO(1L, "김규남")); // key , value 설정
        memberMap.put(2L, new MemberDTO(2L, "김규순"));
    }
    // 회원 전체 조회
    public Map<Long, MemberDTO> selectAllMembers(){
        return memberMap;
    }

    // 회원 번호로 회원 조회
    public MemberDTO selectMemberByNo(Long no) {

        MemberDTO selectedMember = memberMap.get(no);

        if(selectedMember == null){ // 만약 이상한 값이 들어온다면 (1, 2번 이외의 no)
            throw new RuntimeException("해당하는" + no + "번 회원은 없습니다."); // 예외 발생하기
        }
        return selectedMember;
    }

}

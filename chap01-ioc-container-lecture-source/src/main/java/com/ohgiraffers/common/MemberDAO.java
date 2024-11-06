package com.ohgiraffers.common;

import java.util.HashMap;
import java.util.Map;

// 24-11-06 (수) 3교시, annotation 방식, DAO 생성
public class MemberDAO {

    // 가짜 DB 만들기
    private final Map<Integer,MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();
        // 가짜 DB에 데이터 집어 넣기
        memberMap.put(1, new MemberDTO(1,"user01","pass01","김규남"));
        memberMap.put(2, new MemberDTO(2,"user02","pass02","김규순"));
    }
}

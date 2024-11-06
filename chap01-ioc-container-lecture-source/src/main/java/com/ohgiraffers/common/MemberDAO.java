package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 24-11-06 (수) 3교시, annotation 방식, DAO 생성
@Component // DAO를 bean 등록
/* comment. @Component 어노테이션
    IOC 컨테이너에게 Bean으로 등록할 클래스임을 명시하는 어노테이션.
     클래스 레벨에 빈을 등록할 때 이름을 지정하지 않으면
     앞글자가 소문자로 바뀐 것이 이름으로 지정 */
public class MemberDAO {

    // 가짜 DB처럼 만들기
    private final Map<Integer,MemberDTO> memberMap;

    public MemberDAO(){
        memberMap = new HashMap<>();
        // 가짜 DB에 데이터 집어 넣기
        memberMap.put(1, new MemberDTO(1,"user01","pass01","김규남"));
        memberMap.put(2, new MemberDTO(2,"user02","pass02","김규순"));
    }

    public MemberDTO selectMember(int no) {
        return memberMap.get(no); // 1이라고 하면 위에 1에 해당값 리턴하겠다.
    }
    public boolean insertMember (MemberDTO newMember) {
        // 멤버 insert에 성공하면 true, 반대면 false 반환

        int before = memberMap.size(); // 우선 사이즈 측정
        // 예를들어 size가 2에서 insert 성공하면 3으로 변경

        memberMap.put(newMember.getNo(), newMember);
        int after = memberMap.size();

        return after > before ? true : false;
    }
}

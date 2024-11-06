package com.ohgiraffers.section01.javaconfig;

import com.ohgiraffers.common.Account;
import com.ohgiraffers.common.MemberDTO;
import com.ohgiraffers.common.PersonalAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ContextConfiguration {

    @Bean
    public Account account () {
        System.out.println("1번");
        return new PersonalAccount(20, "1002-051-054-123");
        // 실제 인스턴스 생성은 PersonalAccount (Account 는 인터페이스이므로)
    }

    @Bean
    public MemberDTO member(){

        return new MemberDTO(1,"김규남","gyunam@gmail.com", account());
                                                    // account() 메서드를 통해 계좌 정보 전달

    }

}

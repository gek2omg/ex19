package com.example.ex19.member;

import com.example.ex19.member.entity.Member;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class MemberServiceTest {

    private MemberRepository memberRepository;

    @Test
    @DisplayName("Member 회원 저장")
    void saveMemberV1() {

        int i = 1;
        Member member = new Member();
        member.setName("김철수 "+i);
        member.setJumin("111"+i+"-"+"222"+i);
        member.setAddress("서울 강남구 대치"+i+"동");

        memberRepository.save(member);
    }
}
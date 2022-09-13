package com.example.ex19.member;

import com.example.ex19.member.dto.MemberSaveDto;
import com.example.ex19.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    // Service 에서 객체를 생성해서 Form 에서 넘어온 데이터를 매핑
    @Transactional
    public void saveMemberV1(MemberSaveDto memberSaveDto) {

        Member member = new Member();

        member.setName(memberSaveDto.getName());
        member.setJumin(memberSaveDto.getJumin());
        member.setAddress(memberSaveDto.getAddress());

        memberRepository.save(member);
    }


    // Controller 에서 객체를 생성해서 보내기
    @Transactional
    public void saveMemberV2(Member member) {

        memberRepository.save(member);
    }

}

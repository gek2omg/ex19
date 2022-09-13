package com.example.ex19.member;

import com.example.ex19.member.dto.MemberSaveDto;
import com.example.ex19.member.entity.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;


    @GetMapping("/memberCreate")
    public String memberCreate(Model model, MemberSaveDto memberSaveDto) throws  Exception {

        model.addAttribute("memberSaveDto", memberSaveDto);

        return "memberCreate";
    }

    // Service 에서 데이터 처리 예
    @PostMapping("/memberCreate")
    public String memberCreateProc(@Validated @ModelAttribute MemberSaveDto memberSaveDto,
                                   BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "memberCreate";
        }

        try {
            memberService.saveMemberV1(memberSaveDto);
        } catch (Exception e) {
            System.out.println("회원 정보를 저장 오류");
        }

        return "redirect:/memberCreate";
    }

    // Controller 에서 데이터 처리 예
    @PostMapping("/memberCreateV2")
    public String memberCreateV2Proc(@Validated @ModelAttribute MemberSaveDto memberSaveDto,
                                     BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "memberCreate";
        }

        Member member = new Member();

        member.setName(memberSaveDto.getName());
        member.setJumin(memberSaveDto.getJumin());
        member.setAddress(memberSaveDto.getAddress());

        try {
            memberService.saveMemberV2(member);
        } catch (Exception e) {
            System.out.println("회원 정보를 저장 오류");
        }

        return "redirect:/memberCreate";
    }
}

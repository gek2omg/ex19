package com.example.ex19.member;

import com.example.ex19.member.dto.MemberSaveDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
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
    public String memberCreate() {

        return "memberCreate";
    }

    @PostMapping("/memberCreate")
    public String memberCreateProc(@Validated @ModelAttribute MemberSaveDto memberSaveDto,
                                   BindingResult bindingResult) {

        if(bindingResult.hasErrors()) {
            return "memberCreate";
        }

        try {
            memberService.saveMemberV1(memberSaveDto);
        } catch (Exception e) {

        }

        return "redirect:/memberCreate";
    }
}

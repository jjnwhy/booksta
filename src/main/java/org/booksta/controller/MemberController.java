package org.booksta.controller;

import org.booksta.domain.dto.MemberDto;
import org.booksta.service.MemberService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("member")
public class MemberController {
    private final static Logger LOGGER = LoggerFactory.getLogger(MemberController.class);

    @Autowired
    private MemberService memberService;

    /**
     * 회원가입
     * @param memberDto 회원가입
     * @return Long 멤버 아이디
     */
    @PostMapping
    public Long registerMember(@RequestBody MemberDto memberDto) {
        return memberService.registerMember(memberDto);
    }

    /**
     * 로그인
     * @param memberDto 로그인
     * @return String jwt 토큰
     */
    @PostMapping("login")
    public String login(@RequestBody MemberDto memberDto) {
    	return memberService.login(memberDto);
    }
}

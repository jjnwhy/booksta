package org.booksta.service;

import org.booksta.domain.dto.MemberDto;

public interface MemberService {
    Long registerMember(MemberDto memberDto);
    String login(MemberDto memberDto);
}

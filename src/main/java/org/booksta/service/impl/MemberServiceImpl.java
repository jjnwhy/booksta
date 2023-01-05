package org.booksta.service.impl;

import org.booksta.domain.dto.MemberDto;
import org.booksta.service.MemberService;
import org.booksta.store.entity.Member;
import org.booksta.store.repository.MemberRepository;
import org.booksta.jwt.JwtTokenProvider;
import org.booksta.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class MemberServiceImpl implements MemberService {
    
	private final static Logger LOGGER = LoggerFactory.getLogger(MemberServiceImpl.class);

	@Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private MemberRepository memberRepository;

    @Override
    public Long registerMember(MemberDto memberDto) {
    	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    	memberDto.setPassword(encoder.encode(memberDto.getPassword()));
 	
        return memberRepository.save(
                Member.builder()
                        .email(memberDto.getEmail())
                        .password(memberDto.getPassword())
                        .build()
        ).getId();
    }

	@Override
	public String login(MemberDto memberDto) {
		Member member = memberRepository.findByEmail(memberDto.getEmail());
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

		if(!encoder.matches(memberDto.getPassword(), member.getPassword())) {
			// 에러
			throw ExceptionUtil.creatBookstaBizException("BOOKSTA_01");
		}
		return jwtTokenProvider.createToken(member.getEmail());
	}
}

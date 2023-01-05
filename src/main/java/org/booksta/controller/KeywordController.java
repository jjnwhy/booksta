package org.booksta.controller;

import org.booksta.domain.dto.KeywordHistoryDto;
import org.booksta.domain.dto.PopularKeywordDto;
import org.booksta.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("keyword")
public class KeywordController {

    @Autowired
    private KeywordService keywordService;

    /**
     * 사용자의 아이디를 받아서 최근 검색어 목록 조회
     *
     * @param memberId 멤머 아이디
     * @return List<KeywordHistoryDto>
     */
    @GetMapping("history/{memberId}")
    public List<KeywordHistoryDto> findSearchHistory(@PathVariable(name = "memberId") Long memberId) {
        return keywordService.findSearchHistory(memberId);
    }

    /**
     * 인기 키워드 조회
     *
     * @return List<PopularKeywordDto>
     */
    @GetMapping("/popular")
    public List<PopularKeywordDto> findPoppularSearchKeyword() {
        return keywordService.findPopularSearchKeyword();
    }
}

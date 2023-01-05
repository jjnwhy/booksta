package org.booksta.service;


import org.booksta.domain.dto.KeywordHistoryDto;
import org.booksta.domain.dto.PopularKeywordDto;

import java.util.List;

public interface KeywordService {
    List<KeywordHistoryDto> findSearchHistory(Long memeberId);
    List<PopularKeywordDto> findPopularSearchKeyword();
}

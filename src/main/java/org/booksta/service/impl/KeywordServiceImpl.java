package org.booksta.service.impl;

import org.booksta.domain.dto.KeywordHistoryDto;
import org.booksta.domain.dto.PopularKeywordDto;
import org.booksta.service.KeywordService;
import org.booksta.store.entity.SearchKeyword;
import org.booksta.store.repository.SearchKeywordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeywordServiceImpl implements KeywordService {
    private final static Logger LOGGER = LoggerFactory.getLogger(KeywordServiceImpl.class);

    @Autowired
    private SearchKeywordRepository searchKeywordRepository;


    @Override
    public List<KeywordHistoryDto> findSearchHistory(Long memeberId) {
        List<SearchKeyword> searchKeywordList = searchKeywordRepository.findAllByMemberIdOrderBySearchTimeDesc(memeberId);

        return searchKeywordList.stream().map(KeywordHistoryDto::from).collect(Collectors.toList());
    }

    @Override
    public List<PopularKeywordDto> findPopularSearchKeyword() {
        return searchKeywordRepository.findPopularKeyword().stream().limit(10).collect(Collectors.toList());
    }
}

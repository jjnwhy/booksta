package org.booksta.service.impl;

import org.booksta.domain.dto.BookDetailDto;
import org.booksta.domain.dto.BookDetailItemDto;
import org.booksta.domain.dto.BookListDto;
import org.booksta.service.BookService;
import org.booksta.service.client.KakaoBookClient;
import org.booksta.store.entity.SearchKeyword;
import org.booksta.store.repository.SearchKeywordRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {
    private final static Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private KakaoBookClient kakaoBookClient;

    @Autowired
    private SearchKeywordRepository searchKeywordRepository;


    @Override
    public BookListDto searchBook(String title, int page, int size, long memberId) {
        // 검색 테이블(serach_keyword)에 기록 저장
        searchKeywordRepository.save(
                SearchKeyword.builder()
                        .keyword(title)
                        .memberId(memberId)
                        .build()
        );

        return kakaoBookClient.searchBook(title, page, size);
    }


    @Override
    public BookDetailItemDto findBookByIsbn(String isbn) {
        BookDetailDto bookDetailDto = kakaoBookClient.findBookByIsbn(isbn);

        if (bookDetailDto.getDocuments().size() == 0)
            return new BookDetailItemDto();

        return bookDetailDto.getDocuments().get(0);
    }

}

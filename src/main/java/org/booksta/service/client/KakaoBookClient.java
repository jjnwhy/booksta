package org.booksta.service.client;

import org.booksta.domain.dto.BookDetailDto;
import org.booksta.domain.dto.BookListDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class KakaoBookClient {

    @Value("${rest-api-key}")
    private String REST_API_KEY;
    private final String BOOK_URL = "https://dapi.kakao.com/v3/search/book";

    public BookListDto searchBook(String title, int page, int size) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + REST_API_KEY);
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(BOOK_URL)
                .queryParam("target", "title")
                .queryParam("query", title)
                .queryParam("page", page)
                .queryParam("size", size)
                .build();

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, BookListDto.class).getBody();
    }
    public BookDetailDto findBookByIsbn(String isbn) {
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set("Authorization", "KakaoAK " + REST_API_KEY);
        UriComponents builder = UriComponentsBuilder
                .fromHttpUrl(BOOK_URL)
                .queryParam("target", "isbn")
                .queryParam("query", isbn)
                .build();

        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);

        return restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity, BookDetailDto.class).getBody();
    }
}

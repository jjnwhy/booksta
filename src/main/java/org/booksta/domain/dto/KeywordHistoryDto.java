package org.booksta.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.booksta.store.entity.SearchKeyword;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
public class KeywordHistoryDto {
    private String keyword;
    private LocalDateTime datetime;

    public static KeywordHistoryDto from(SearchKeyword searchKeyword) {
        KeywordHistoryDto keywordHistoryDto = new KeywordHistoryDto();

        keywordHistoryDto.setKeyword(searchKeyword.getKeyword());
        keywordHistoryDto.setDatetime(searchKeyword.getSearchTime());

        return keywordHistoryDto;
    }
}

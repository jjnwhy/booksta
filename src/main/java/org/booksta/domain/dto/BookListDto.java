package org.booksta.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class BookListDto {
    private List<BookItemDto> documents;
    private Map meta;


    @Setter
    @Getter
    @NoArgsConstructor
    public static class BookItemDto {
        private String title;
        private String isbn;
        private String datetime;
        private int salePrice;
        private String status;
    }
}

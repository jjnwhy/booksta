package org.booksta.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Setter
@Getter
@NoArgsConstructor
public class BookClientDto {
    private List<BookDetailDto> documents;
    private Map meta;
}

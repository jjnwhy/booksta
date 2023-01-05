package org.booksta.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
public class BookDetailDto {
    private List<BookDetailItemDto> documents;

}

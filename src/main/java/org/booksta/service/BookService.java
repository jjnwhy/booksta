package org.booksta.service;

import org.booksta.domain.dto.BookDetailItemDto;
import org.booksta.domain.dto.BookListDto;

public interface BookService {
    BookListDto searchBook(String title, int page, int size, long memberId);
    BookDetailItemDto findBookByIsbn(String isbn);

}

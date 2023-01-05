package org.booksta.controller;

import org.booksta.domain.dto.BookDetailItemDto;
import org.booksta.domain.dto.BookListDto;
import org.booksta.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("book")
public class BookController {
    @Autowired
    private BookService bookService;

    /**
     * @param title 제목
     * @param page  결과 페이지 번호
     * @param size  한 페이지에 보여질 문서 수
     * @return BookDto
     */
    @GetMapping
    public BookListDto searchBook(@RequestParam(name = "title") String title,
                                  @RequestParam(name = "page", defaultValue = "1", required = false) int page,
                                  @RequestParam(name = "size", defaultValue = "10", required = false) int size,
                                  @RequestParam(name = "memberId") long memberId) {
        return bookService.searchBook(title, page, size, memberId);
    }

    /**
     * isbn으로 책 상세 조회
     *
     * @param isbn ISBN
     * @return BookDetailItemDto
     */
    @GetMapping("{isbn}")
    public BookDetailItemDto findBookByIsbn(@PathVariable(name = "isbn") String isbn) {
        return bookService.findBookByIsbn(isbn);
    }

}

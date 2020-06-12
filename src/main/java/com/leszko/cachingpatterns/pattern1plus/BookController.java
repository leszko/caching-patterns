package com.leszko.cachingpatterns.pattern1plus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/{isbn}")
    public String getBookNameByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getBookNameByIsbn(isbn);
    }

    @GetMapping("/first-letter/{isbn}")
    public String getFirstLetterOfBookByIsbn(@PathVariable("isbn") String isbn) {
        return bookService.getFirstLetterOfBookByIsbn(isbn);
    }
}

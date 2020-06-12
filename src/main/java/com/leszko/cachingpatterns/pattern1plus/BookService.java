package com.leszko.cachingpatterns.pattern1plus;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookService {
    @Resource
    private BookService self;

    @Cacheable("books")
    public String getBookNameByIsbn(String isbn) {
        return findBookInSlowSource(isbn);
    }

    public String getFirstLetterOfBookByIsbn(String isbn) {
        return self.getBookNameByIsbn(isbn).substring(0, 1);
    }

    private String findBookInSlowSource(String isbn) {
        // some long processing
        sleep();
        return "Sample Book Name";
    }

    private void sleep() {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

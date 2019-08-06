package com.leszko.cachingpatterns.spring;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class BookService {
    @Cacheable("books")
    public String getBookNameByIsbn(String isbn) {
        return findBookInSlowSource(isbn);
    }

    private String findBookInSlowSource(String isbn) {
        // some long processing
        return null;
    }

    @CacheEvict(value = "someValue", allEntries = true)
    public void evictAllCacheValues() {}
}

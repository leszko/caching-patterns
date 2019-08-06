package com.leszko.cachingpatterns.simple;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.time.Duration;

public class GuavaCaching {
    public static void main(String[] args) {
        Cache<String, String> cache = CacheBuilder.newBuilder()
            .initialCapacity(300)
            .expireAfterAccess(Duration.ofMinutes(10))
            .maximumSize(1000)
            .build();
    }
}

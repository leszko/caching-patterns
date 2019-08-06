package com.leszko.cachingpatterns.simple;

import java.util.concurrent.ConcurrentHashMap;

public class PureJavaCaching {
    private ConcurrentHashMap<String, String> cache = new ConcurrentHashMap<>();

    private String processRequest(String request) {
        if (cache.contains(request)) {
            return cache.get(request);
        }
        String response = process(request);
        cache.put(request, response);
        return response;
    }

    private String process(String request) {
        // some long processing
        return null;
    }

    private void run() {
        String request = readRequest();
        writeReponse(processRequest(request));
    }

    private String readRequest() {
        // not important
        return null;
    }

    private void writeReponse(String response) {
        // not important
    }

    public static void main(String[] args) {
        new PureJavaCaching().run();
    }
}

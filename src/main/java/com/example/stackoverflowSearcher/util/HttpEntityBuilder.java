package com.example.stackoverflowSearcher.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class HttpEntityBuilder {

    public static HttpEntity getHttpEntity() {
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<String, String>();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE);
        headers.add(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
        return new HttpEntity(headers);
    }
}

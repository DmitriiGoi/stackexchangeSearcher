package com.example.stackoverflowSearcher.service.external.impl;

import com.example.stackoverflowSearcher.domain.SearchResponseDto;
import com.example.stackoverflowSearcher.exception.SearcherException;
import com.example.stackoverflowSearcher.service.external.ExternalStackOverflowService;
import com.example.stackoverflowSearcher.util.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

import static com.example.stackoverflowSearcher.util.HttpEntityBuilder.getHttpEntity;
import static com.example.stackoverflowSearcher.util.StackexchangeUriBuilder.getUriBuilder;

@Service
public class ExternalStackOverflowServiceImpl implements ExternalStackOverflowService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${search.site}")
    private String site;

    @Override
    public SearchResponseDto searchQuestions(String query, Pageable pageable) {
        URI queryURI = getUriBuilder(site)
                .forSiteStackoverflow()
                .withQuery(query)
                .withPageNumber(pageable.getPage())
                .withPageSize(pageable.getPageSize()).build();

        ResponseEntity<SearchResponseDto> exchange;
        try {
            exchange = restTemplate.exchange(queryURI, HttpMethod.GET, getHttpEntity(), SearchResponseDto.class);
        } catch (HttpClientErrorException exception) {
            String responseBody = exception.getResponseBodyAsString();
            throw new SearcherException(responseBody, exception);
        }
        return exchange != null ? exchange.getBody() : null;
    }
}

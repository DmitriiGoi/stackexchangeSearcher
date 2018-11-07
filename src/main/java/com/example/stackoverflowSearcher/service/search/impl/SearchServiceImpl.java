package com.example.stackoverflowSearcher.service.search.impl;

import com.example.stackoverflowSearcher.domain.SearchResponseDto;
import com.example.stackoverflowSearcher.service.external.ExternalStackOverflowService;
import com.example.stackoverflowSearcher.service.search.SearchService;
import com.example.stackoverflowSearcher.util.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ExternalStackOverflowService externalStackOverflowService;

    @Override
    public SearchResponseDto searchInStackOverFlow(String query, Pageable pageRequest) {
        return externalStackOverflowService.searchQuestions(query, pageRequest);
    }
}

package com.example.stackoverflowSearcher.service.search;

import com.example.stackoverflowSearcher.domain.SearchResponseDto;
import com.example.stackoverflowSearcher.util.Pageable;

public interface SearchService {

    SearchResponseDto searchInStackOverFlow(String query, Pageable pageRequest);
}

package com.example.stackoverflowSearcher.service.external;

import com.example.stackoverflowSearcher.domain.SearchResponseDto;
import com.example.stackoverflowSearcher.util.Pageable;

public interface ExternalStackOverflowService {

    SearchResponseDto searchQuestions(String query, Pageable pageable);
}

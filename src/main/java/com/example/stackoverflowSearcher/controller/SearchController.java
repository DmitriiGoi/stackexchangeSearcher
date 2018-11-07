package com.example.stackoverflowSearcher.controller;

import com.example.stackoverflowSearcher.domain.SearchResponseDto;
import com.example.stackoverflowSearcher.service.search.SearchService;
import com.example.stackoverflowSearcher.util.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
public class SearchController {

    private static final int INITIAL_PAGE = 1;
    private static final int INITIAL_PAGE_SIZE = 10;


    @Autowired
    private SearchService searchService;


    @GetMapping("/search")
    public ResponseEntity<SearchResponseDto> searchInStackoverflow(@RequestParam("query") String query,
                                                                   @RequestParam("pageSize") Optional<Integer> pageSize,
                                                                   @RequestParam("page") Optional<Integer> page) {
        int evalPageSize = pageSize.orElse(INITIAL_PAGE_SIZE);
        int evalPage = (page.orElse(0) < 1) ? INITIAL_PAGE : page.get();
        return ResponseEntity.ok(searchService.searchInStackOverFlow(query, new Pageable(evalPage, evalPageSize)));
    }
}

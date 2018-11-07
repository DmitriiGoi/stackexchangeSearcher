package com.example.stackoverflowSearcher.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchResponseDto {

    private List<QuestionDto> items;

    private Boolean hasMore;

    public List<QuestionDto> getItems() {
        return items;
    }

    public void setItems(List<QuestionDto> items) {
        this.items = items;
    }

    @JsonProperty("has_more")
    public Boolean getHasMore() {
        return hasMore;
    }

    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
}

package com.example.stackoverflowSearcher.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class QuestionDto {

    private List<String> tags;

    private Boolean isAnswered;

    private String link;

    private String title;

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @JsonProperty("is_answered")
    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}


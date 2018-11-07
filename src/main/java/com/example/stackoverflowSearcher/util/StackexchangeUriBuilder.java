package com.example.stackoverflowSearcher.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class StackexchangeUriBuilder {

    private MultiValueMap<String, String> pathVariables;
    private UriComponentsBuilder uriComponentsBuilder;
    private String site;

    private StackexchangeUriBuilder(String site) {
        this.uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl("http://api.stackexchange.com/2.2/search");
        this.pathVariables = new LinkedMultiValueMap<>();
        this.site = site;

    }

    public static StackexchangeUriBuilder getUriBuilder(String site) {
        return new StackexchangeUriBuilder(site);
    }

    public StackexchangeUriBuilder withQuery(String query) {
        this.pathVariables.add("intitle", query);
        return this;
    }

    public StackexchangeUriBuilder forSiteStackoverflow() {
        this.pathVariables.add("site", site);
        return this;
    }

    public StackexchangeUriBuilder withPageNumber(int pageNumber) {
        this.pathVariables.add("page", String.valueOf(pageNumber));
        return this;
    }

    public StackexchangeUriBuilder withPageSize(int pageSize) {
        this.pathVariables.add("pagesize", String.valueOf(pageSize));
        return this;
    }

    public URI build() {
        uriComponentsBuilder.queryParams(pathVariables);
        return uriComponentsBuilder.build().encode().toUri();
    }
}

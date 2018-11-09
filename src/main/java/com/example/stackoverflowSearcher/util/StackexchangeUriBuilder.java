package com.example.stackoverflowSearcher.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;


public class StackexchangeUriBuilder {

    private static final String STACKEXCHANGE_SEARCH_URI = "http://api.stackexchange.com/2.2/search";
    private static final String INTITLE_REQUEST_PARAM = "intitle";
    private static final String SITE_REQUEST_PARAM = "site";
    private static final String PAGE_REQUEST_PARAM = "page";
    private static final String PAGESIZE_REQUEST_PARAM = "pagesize";
    private MultiValueMap<String, String> pathVariables;
    private UriComponentsBuilder uriComponentsBuilder;
    private String site;

    private StackexchangeUriBuilder(String site) {
        this.uriComponentsBuilder = UriComponentsBuilder.fromHttpUrl(STACKEXCHANGE_SEARCH_URI);
        this.pathVariables = new LinkedMultiValueMap<>();
        this.site = site;

    }

    public static StackexchangeUriBuilder getUriBuilder(String site) {
        return new StackexchangeUriBuilder(site);
    }

    public StackexchangeUriBuilder withQuery(String query) {
        this.pathVariables.add(INTITLE_REQUEST_PARAM, query);
        return this;
    }

    public StackexchangeUriBuilder forSiteStackoverflow() {
        this.pathVariables.add(SITE_REQUEST_PARAM, site);
        return this;
    }

    public StackexchangeUriBuilder withPageNumber(int pageNumber) {
        this.pathVariables.add(PAGE_REQUEST_PARAM, String.valueOf(pageNumber));
        return this;
    }

    public StackexchangeUriBuilder withPageSize(int pageSize) {
        this.pathVariables.add(PAGESIZE_REQUEST_PARAM, String.valueOf(pageSize));
        return this;
    }

    public URI build() {
        uriComponentsBuilder.queryParams(pathVariables);
        return uriComponentsBuilder.build().encode().toUri();
    }
}

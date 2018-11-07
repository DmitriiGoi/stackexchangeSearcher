package com.example.stackoverflowSearcher.util;

public class Pageable {
    private int pageSize;
    private int page;

    public Pageable(int page, int pageSize) {
        this.pageSize = pageSize;
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }
}

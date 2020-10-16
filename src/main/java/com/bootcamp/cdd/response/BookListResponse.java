package com.bootcamp.cdd.response;

public class BookListResponse {
    private final String title;
    private final String desc;

    public BookListResponse(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public String getDesc() {
        return desc;
    }
}

package com.deo.rest;

public class Greetings {
    public final long id;
    public final String content;


    public Greetings(long id, String content) {
        this.id = id;
        this.content =content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
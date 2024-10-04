package org.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Post {
    private int userId;
    private int id;
    private String title;
    private String body;

    public Post() {
    }

    @JsonProperty("userId")
    public int getUserId() {
        return userId;
    }

    @JsonProperty("id")
    public int getId() {
        return id;
    }

    @JsonProperty("title")
    public String getTitle() {
        return title;
    }

    @JsonProperty("body")
    public String getBody() {
        return body;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

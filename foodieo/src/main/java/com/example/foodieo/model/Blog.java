package com.example.foodieo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Document
public class Blog {
    @Id
    private String id;

    private String userId;

    @NotNull(message = "Title cannot be empty")
    private String title;

    @NotNull(message = "Give a simple summary")
    private String summary;

    @NotNull(message = "Give a detailed description")
    private String blogBody;

    private Date createdOn;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBlogBody() {
        return blogBody;
    }

    public void setBlogBody(String blogBody) {
        this.blogBody = blogBody;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn() {
        this.createdOn = new Date();
    }
}

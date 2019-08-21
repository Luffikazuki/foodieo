package com.example.foodieo.services;

import com.example.foodieo.model.Blogger;

public interface BloggerService {
    public void saveBlogger(Blogger blogger);
    public Blogger getEmployee(String emailId, String password);
    public Blogger checkEmailId(String emailId);
}

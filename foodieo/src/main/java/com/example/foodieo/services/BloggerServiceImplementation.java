package com.example.foodieo.services;

import com.example.foodieo.data.BloggerRepository;
import com.example.foodieo.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BloggerServiceImplementation implements BloggerService {

    @Autowired
    public BloggerRepository bloggerRepository;

    public void saveBlogger(Blogger blogger){
        bloggerRepository.save(blogger);
    }

    public Blogger getEmployee(String emailId,String password){
        Blogger blogger = bloggerRepository.findByEmailIdAndPassword(emailId,password);
        return blogger;
    }

    public Blogger checkEmailId(String emailId){
        return bloggerRepository.findByEmailId(emailId);

    }


}

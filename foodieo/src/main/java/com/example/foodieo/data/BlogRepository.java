package com.example.foodieo.data;

import com.example.foodieo.model.Blog;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BlogRepository extends MongoRepository<Blog,String> {
    public List<Blog> findByUserId(String userId);
    public List<Blog> findAll();
}

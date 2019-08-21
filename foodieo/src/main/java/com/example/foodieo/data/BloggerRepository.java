package com.example.foodieo.data;

import com.example.foodieo.model.Blogger;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BloggerRepository extends MongoRepository<Blogger, String> {

    Blogger findByEmailIdAndPassword(String emailId,String password);
    Blogger findByEmailId(String emailId);
}

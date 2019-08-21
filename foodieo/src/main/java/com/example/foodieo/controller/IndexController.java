package com.example.foodieo.controller;

import com.example.foodieo.data.BlogRepository;
import com.example.foodieo.model.Blog;
import com.example.foodieo.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import java.util.List;


@Controller
@SessionAttributes("blogger")
public class IndexController {

    @Autowired
    public BlogRepository blogRepository;

    @ModelAttribute(name ="blogger")
    public Blogger blogger(){
        return new Blogger();
    }

    @GetMapping("/")
    public String investorfunc(@ModelAttribute Blogger blogger, SessionStatus sessionStatus, Model model) {
        List<Blog> blogs = blogRepository.findAll();
        model.addAttribute("blogs",blogs);
        sessionStatus.setComplete();
        return "index";
    }

}

package com.example.foodieo.controller;

import com.example.foodieo.data.BlogRepository;
import com.example.foodieo.model.Blog;
import com.example.foodieo.model.Blogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("blogger")
public class BlogController {

    private String blogids;

    @Autowired
    public BlogRepository blogRepository;

    @GetMapping("writeblog")
    public String showwriteBlog(@ModelAttribute Blogger blogger,
                            Model model){
        model.addAttribute("blogger",blogger);
        model.addAttribute("loggedIn","yes");
        model.addAttribute("blog",new Blog());
        return "writeblog";
    }
    @PostMapping("writeblog")
    public String porcessWriteBlog(@ModelAttribute Blogger blogger,
                                   Model model,
                                   Blog blog){
        blog.setUserId(blogger.getId());
        blog.setCreatedOn();
        blogRepository.save(blog);
        return "redirect:showmyblog";
    }

    @RequestMapping(value = "/editblog/{blogId}", method= RequestMethod.GET)
    public String showEditMyBlog(@PathVariable String blogId,
                                            @ModelAttribute Blogger blogger,
                                            Model model){
        Optional<Blog> blog = blogRepository.findById(blogId);
        model.addAttribute("blogs",blog.get());
        model.addAttribute("loggedIn","yes");
        model.addAttribute("blog",new Blog());
        return "editmyblog";

    }

    @RequestMapping(value = "/editblog/{blogId}", method= RequestMethod.POST)
    public String processEditMyBlog(@PathVariable String blogId,
                                    @ModelAttribute Blogger blogger,
                                    Model model,
                                    Blog blog){
        blog.setUserId(blogger.getId());
        blog.setId(blogId);
        blog.setCreatedOn();
        blogRepository.save(blog);
        return "redirect:/showmyblog";

    }

    @RequestMapping(value = "/deleteblog/{blogId}", method= RequestMethod.GET)
    public String processDeleteBlog(@PathVariable String blogId,
                                            @ModelAttribute Blogger blogger,
                                            Model model){
        Optional<Blog> blog = blogRepository.findById(blogId);
        blogRepository.delete(blog.get());
        return "redirect:/showmyblog";

    }



    @GetMapping("/showblog")
    public String showBlog(){return "index";}

    @GetMapping("/showmyblog")
    public String showMyBlog(@ModelAttribute Blogger blogger,
                             Model model){

            model.addAttribute("blogger",blogger);
            model.addAttribute("loggedIn","yes");
            List<Blog> blog = blogRepository.findByUserId(blogger.getId());
            if(blog.isEmpty()){
                model.addAttribute("blogExist","no");
            }else{
                model.addAttribute("blogs",blog);
                model.addAttribute("blogExist","yes");
            }
        return "showmyblog";
    }
}

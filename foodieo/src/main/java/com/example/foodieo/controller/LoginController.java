package com.example.foodieo.controller;

import com.example.foodieo.model.Blogger;
import com.example.foodieo.model.BloggerLogin;
import com.example.foodieo.services.BloggerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.validation.Valid;

@Controller
@SessionAttributes("blogger")
public class LoginController {

    @Autowired
    public BloggerServiceImplementation bloggerServiceImplementation;
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("bloggerLogin",new BloggerLogin());
        return "login";
    }

    @PostMapping("/login")
    public String processLoginPage(@Valid BloggerLogin bloggerLogin,
                                   Errors errors,
                                   Model model){
        if(errors.hasErrors()){
            return "login";
        }else{
            Blogger blogger = bloggerServiceImplementation.getEmployee(bloggerLogin.getEmailId(),bloggerLogin.getPassword());
            if(blogger != null){
                model.addAttribute("blogger",blogger);
                return "redirect:/showmyblog";
            }
            else{
                model.addAttribute("errorMessage","yes");
                return "login";
            }
        }
    }



    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("blogger",new Blogger());
        return "register";
    }

    @PostMapping("/register")
    public String processRegisterPage(@Valid Blogger blogger,
                                      Errors errors,
                                      Model model){
        if(errors.hasErrors()){
            return "register";
        }else{
            Blogger blogger1 = bloggerServiceImplementation.checkEmailId(blogger.getEmailId());
            if(blogger1 == null){
                bloggerServiceImplementation.saveBlogger(blogger);
                model.addAttribute("success","yes");
                return "register";
            }
            else{
                model.addAttribute("emailExist","yes");
                return "register";
            }
        }
    }
}

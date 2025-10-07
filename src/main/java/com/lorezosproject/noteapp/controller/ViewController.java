package com.lorezosproject.noteapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class ViewController {

    //access the landing page
    @GetMapping("/")
    public String xxxx(){
        return "landing-page";
    }

    //access homepage
    @GetMapping("/home-page")
    public String TheHomePage(){
        return "home-page";
    }

    //access denied page
    @GetMapping("/access-denied")
    public String accessDeniedPage(){
        return "access-denied";
    }

    //access the register page
    @GetMapping("/register")
    public String registerForm(){
        return "register";
    }

    //access the add-note page
    @GetMapping("/new-note")
    public String newNoteForm(){
        return "new-note";
    }
}

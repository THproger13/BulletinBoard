package com.example.bulletinboard.controller;

import org.springframework.stereotype.Controller;

@Controller
public class HomeController {
    public String Home() {
        return "/";
    }
}

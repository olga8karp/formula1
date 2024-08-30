package com.github.okarpenko.formula1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(path = "/")
    public String homePage() {
        return "index";
    }

}

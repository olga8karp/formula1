package com.github.okarpenko.formula1.controller;

import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePageController {

    @GetMapping(path = "/")
    public String homePage() {
        return "redirect:/driver/rankings/" + LocalDate.now().getYear();
    }

}

package com.github.okarpenko.formula1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CircuitController {

    @GetMapping(path = "/circuits")
    public String circuitsPage() {
        return "circuits";
    }
}

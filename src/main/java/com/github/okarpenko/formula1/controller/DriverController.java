package com.github.okarpenko.formula1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DriverController {

    @GetMapping(path = "/drivers")
    public String driversPage() {
        return "drivers";
    }
}

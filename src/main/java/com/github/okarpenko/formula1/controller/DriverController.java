package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.service.DriverService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @GetMapping("/driver-info/{name}")
    public String getDriverPage(@PathVariable("name") String name){
        String firstName = name.split(" ")[0]; // Max Verstappen becomes just max

        return "driver-page";
    }



}

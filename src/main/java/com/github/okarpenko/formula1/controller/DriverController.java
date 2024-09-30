package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.service.DriverService;
import org.springframework.stereotype.Controller;

@Controller
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }



}

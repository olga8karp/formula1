package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.Driver;
import com.github.okarpenko.formula1.service.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }


    @GetMapping(path = "/drivers/{name}")
    public String driverPage(@RequestParam(name = "search") String name, Model model) {
        Driver circuit = driverService.findByName(name);
        model.addAttribute("driver", circuit);
        return "driver";
    }

}

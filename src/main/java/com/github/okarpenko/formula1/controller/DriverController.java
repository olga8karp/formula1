package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.Driver;
import com.github.okarpenko.formula1.service.DriverService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping(path = "/drivers")
    public String driversPage(Pageable pageable, Model model) {
        Page<Driver> driversPage = driverService.findAll(pageable);
        model.addAttribute("driversPage", driversPage);
        return "drivers";
    }

    @GetMapping(path = "/drivers/{id}")
    public String driverPage(@PathVariable(name = "id") Long id, Model model) {
        Driver circuit = driverService.findById(id);
        model.addAttribute("driver", circuit);
        return "driver";
    }

}

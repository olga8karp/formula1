package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.details.DriverDetails;
import com.github.okarpenko.formula1.service.DriverDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class DriverController {

    private final DriverDetailsService driverDetailsService;

    @GetMapping("/driver-info/{name}")
    public String getDriverPage(@PathVariable("name") String name, Model model){
        String lastName = name.split(" ")[1];
        DriverDetails driverDetails = driverDetailsService.retrieveDriverDetailsByLastName(lastName);
        model.addAttribute("driverDetails", driverDetails);
        return "driver-page";
    }



}

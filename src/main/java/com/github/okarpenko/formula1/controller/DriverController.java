package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.details.DriverDetails;
import com.github.okarpenko.formula1.entity.details.DriverInfoDetails;
import com.github.okarpenko.formula1.service.DriverDetailsService;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import java.time.LocalDate;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@AllArgsConstructor
public class DriverController {

    private final DriverDetailsService driverDetailsService;
    private final Formula1HttpClient client;

    @GetMapping("/driver-info/{name}")
    public String getDriverPage(@PathVariable("name") String name, Model model){
        String lastName = name.split(" ")[1];
        List<DriverInfoDetails> driverInfoDetails = client.getDriversInfo();
        DriverInfoDetails driverInfo = getDriverInfoDetails(driverInfoDetails, lastName);
        DriverDetails driverDetails = new DriverDetails();
        driverDetails.setId(driverInfo.getDriverNumber());
        driverDetails.setAbbr(driverInfo.getNameAcronym());
        driverDetails.setFirstName(driverInfo.getFirstName());
        driverDetails.setLastName(driverInfo.getLastName());
        driverDetails.setProfileImage(driverInfo.getHeadshotUrl());
        driverDetails.setCountry(driverInfo.getCountryCode());
        driverDetails.setBiography("");
        driverDetails.setDateOfBirth(LocalDate.now());
        model.addAttribute("driverDetails", driverDetails);
        return "driver-page";
    }

    private DriverInfoDetails getDriverInfoDetails(List<DriverInfoDetails> driverInfoDetails, String lastName) {
        return driverInfoDetails.stream()
            .filter(driver -> driver.getLastName().equals(lastName))
            .findFirst()
            .orElseThrow(() -> new RuntimeException("Driver not found"));
    }


}

package com.github.okarpenko.formula1.controller;

import com.github.okarpenko.formula1.entity.Circuit;
import com.github.okarpenko.formula1.service.CircuitService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CircuitController {

    private final CircuitService circuitService;

    public CircuitController(CircuitService circuitService) {
        this.circuitService = circuitService;
    }

    @GetMapping(path = "/circuits")
    public String circuitsPage(Pageable pageable, Model model) {
        Page<Circuit> circuitsPage = circuitService.findAll(pageable);
        model.addAttribute("circuitsPage", circuitsPage);
        return "circuits";
    }

    @GetMapping(path = "/circuits/{id}")
    public String circuitPage(@PathVariable(name = "id") Long id, Model model) {
        Circuit circuit = circuitService.findById(id);
        model.addAttribute("circuit", circuit);
        return "circuit";
    }
}

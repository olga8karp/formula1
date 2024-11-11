package com.github.okarpenko.formula1.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AdminPageController {

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/admin/add-team")
    public String getTeamPage(Model model,
        @RequestParam(value = "errorMessage", required = false, defaultValue = "") String errorMessage) {
        model.addAttribute("errorMessage", errorMessage);
        return "admin-team";
    }

}

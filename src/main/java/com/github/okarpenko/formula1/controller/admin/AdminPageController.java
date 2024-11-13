package com.github.okarpenko.formula1.controller.admin;

import com.github.okarpenko.formula1.entity.details.TeamDetails;
import com.github.okarpenko.formula1.service.TeamDetailsService;
import com.github.okarpenko.formula1.service.client.Formula1HttpClient;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.github.okarpenko.formula1.entity.Team;


@Controller
@RequiredArgsConstructor
public class AdminPageController {

    private final Formula1HttpClient formula1HttpClient;
    private final TeamDetailsService teamDetailsService;

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/admin/add-team")
    public String getTeamPage(Model model,
        @RequestParam(value = "errorMessage", required = false, defaultValue = "") String errorMessage) {
        model.addAttribute("errorMessage", errorMessage);
        model.addAttribute("teams", getTeamListAsString());
        return "admin-team";
    }

    private List<String> getTeamListAsString() {
        return formula1HttpClient.getTeams().stream().map(Team::getName).toList();
    }

}

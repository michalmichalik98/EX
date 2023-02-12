package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerTeams;
import com.isa.vacationplanerwebapp.model.Team;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


public class TeamController {
    private final DataManagerTeams dataManagerTeams;

    public TeamController(DataManagerTeams dataManagerTeams) {
        this.dataManagerTeams = dataManagerTeams;
    }

    @GetMapping("/teamList.html")
    public String getEmployee(Model model) {
        List<Team> team = dataManagerTeams.getTeams();
        model.addAttribute("AllTeam", team);
        return "/teamList.html";
    }

}

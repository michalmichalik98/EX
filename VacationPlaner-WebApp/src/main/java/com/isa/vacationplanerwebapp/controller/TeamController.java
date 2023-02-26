package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.dataManager.DataManagerTeams;
import com.isa.vacationplanerwebapp.model.Team;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;


@Controller
public class TeamController {
    private final DataManagerTeams dataManagerTeams;
    private final DataManagerEmployees dataManagerEmployees;

    @Autowired
    public TeamController(DataManagerTeams dataManagerTeams, DataManagerEmployees dataManagerEmployees) {
        this.dataManagerTeams = dataManagerTeams;
        this.dataManagerEmployees = dataManagerEmployees;
    }

    @GetMapping("/teamAdd")
    public String addTeam(Model model) {
        Team team = new Team();
        model.addAttribute("teamKeyAdd", team);
        return "teamAdd";
    }

    @PostMapping("/teamAdd")
    public String addTeamRequest(@Valid Team team, BindingResult result) {
        if (result.hasErrors()) {
            return "teamAdd";
        }
        dataManagerTeams.addTeam(team);
        return "redirect:/teamList";
    }

    @GetMapping("/teamDelete")
    public String deleteTeam(Model model) {
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        return "/teamDelete";
    }

    @GetMapping("/teamDelete/{teamName}")
    public String deleteTeamRequest(@PathVariable(required = false, name = "teamName") String teamName) {
        dataManagerTeams.deleteTeam(teamName);
        return "redirect:/teamDelete";
    }

    @GetMapping("/teamModify")
    public String modifyTeam(Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        model.addAttribute("teamKeyModify", new Team());
        return "teamModify";
    }

    @PostMapping("/teamModify/")
    public String modifyTeamRequest(@ModelAttribute("teamKeyModify") Team team) {
        dataManagerTeams.modifyTeam(team.getTeamName());
        return "redirect:/teamModify";
    }

    @GetMapping("/teamList")
    public String listOfTeams(Model model) {
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        return "teamList";
    }

    @GetMapping("/teamModifySelectedTeam/{teamName}")
    public String SelectedTeamModify(@PathVariable(required = true, name = "teamName") String teamName, Model model){

        model.addAttribute("AllEmployees", dataManagerEmployees.getUnAssignedEmployees(teamName));

        return "/teamModifySelectedTeam";
    }

}


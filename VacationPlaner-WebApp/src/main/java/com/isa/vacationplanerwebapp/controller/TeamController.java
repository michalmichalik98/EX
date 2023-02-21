package com.isa.vacationplanerwebapp.controller;

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
    @Autowired
    public TeamController(DataManagerTeams dataManagerTeams) {
        this.dataManagerTeams = dataManagerTeams;
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
    public String deleteTeamRequest(@PathVariable(required = false, name="teamName") String teamName) {
        dataManagerTeams.deleteTeam(teamName);
        return "redirect:/teamDelete";
        }

    @GetMapping("/teamModify")
    public String modifyTeam(Model model) {

        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        model.addAttribute("teamKeyModify", new Team());
        return "teamModify";
    }
    @GetMapping("/teamModify/{teamName}")
    public String displayTeamToModify(@PathVariable(required = false, name="teamName") String teamName, Model model) {

        model.addAttribute("teamKeyModify", dataManagerTeams.getTeamByName(teamName));
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());

        return "teamModify";
    }

    @PostMapping("/teamModify/{teamName}")
    public String modifyTeamRequest(@PathVariable String teamName, @ModelAttribute("teamKeyModify") Team team) {
        dataManagerTeams.modifyTeam(teamName, team);
        return "redirect:/teamModify";
    }

        @GetMapping("/teamList")
        public String listOfTeams(Model model) {
            model.addAttribute("AllTeams", dataManagerTeams.getTeams());
            return "teamList";
        }
}


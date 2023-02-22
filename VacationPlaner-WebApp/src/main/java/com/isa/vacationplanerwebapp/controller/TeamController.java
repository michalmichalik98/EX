package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerTeams;
import com.isa.vacationplanerwebapp.model.Team;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TeamController {
    private final DataManagerTeams dataManagerTeams;

    public TeamController(DataManagerTeams dataManagerTeams) {
        this.dataManagerTeams = dataManagerTeams;
    }

    @GetMapping("/teamAdd")
    public String addTeams(Model model) {
        List<Team> teams = dataManagerTeams.getTeams();
        model.addAttribute("AllTeams", teams);
        model.addAttribute("Team", new Team());
        return "teamAdd";
    }

    @PostMapping("/teamAdd")
    public String addTeamRequest(Team team, Model model) {
        boolean hasBeenAdded = false;
        model.addAttribute("hasBeenAdded", hasBeenAdded);

        if (dataManagerTeams.addTeam(team)) {
            hasBeenAdded = true;
            return "redirect:/teamAdd";
        }
        return "redirect:/teamAdd";
    }
/*   @PostMapping( "/teamAdd")
   public String addTeamRequest(@Valid @ModelAttribute("team") Team team, BindingResult result, Model model) {

       if (dataManagerTeams.teamWithNameExists(team.getTeamName())) {
           result.rejectValue("teamName", "error.Team", "A team already exists.");

           return "redirect:/teamAdd";
       }
       dataManagerTeams.addTeam(team);
       model.addAttribute("AllTeams", dataManagerTeams.getTeams());
       return "teamAdd";
   }*/
}

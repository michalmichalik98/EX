package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.dataManager.DataManagerTeams;
import com.isa.vacationplanerwebapp.model.Employee;
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
    public String deleteTeamRequest(@PathVariable( name = "teamName") String teamName) {
        dataManagerTeams.deleteTeam(teamName);
        dataManagerEmployees.removeAllEmployeesFromTeam(teamName);
        return "redirect:/teamDelete";
    }

    @GetMapping("/teamModify")
    public String modifyTeam(Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        model.addAttribute("teamKeyModify", new Team());
        return "teamModify";
    }


    @GetMapping("/teamList")
    public String listOfTeams(Model model) {
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        return "teamList";
    }

    @GetMapping("/teamModifySelectedTeam/{teamName}")
    public String SelectedTeamModify(@PathVariable(name = "teamName") String teamName, Model model) {

        model.addAttribute("AllTeamEmployees", dataManagerEmployees.getEmployeesByTeam(teamName));
        model.addAttribute("AllUnassignedEmployees", dataManagerEmployees.getEmployeesByTeam(Employee.UNASSIGNED_TEAM));
        model.addAttribute("TeamName", teamName);
        return "/teamModifySelectedTeam";
    }

    @GetMapping("/teamModifySelectedTeam/delete/{id}/{teamName}")
    public String deleteTeamMember(@PathVariable(name = "id") String id,
                                   @PathVariable(name = "teamName") String teamName,
                                   Model model) {

        dataManagerEmployees.setTeamToUnassigned(id);

        model.addAttribute("AllTeamEmployees", dataManagerEmployees.getEmployeesByTeam(teamName));
        model.addAttribute("AllUnassignedEmployees", dataManagerEmployees.getEmployeesByTeam(Employee.UNASSIGNED_TEAM));
        model.addAttribute("TeamName", teamName);

        return "/teamModifySelectedTeam";
    }

    @GetMapping("/teamModifySelectedTeam/add/{id}/{teamName}")
    public String addTeamMember(@PathVariable(name = "id") String id,
                                @PathVariable(name = "teamName") String teamName,
                                Model model) {

        dataManagerEmployees.addEmployeeToTeam(id, teamName);

        model.addAttribute("AllTeamEmployees", dataManagerEmployees.getEmployeesByTeam(teamName));
        model.addAttribute("AllUnassignedEmployees", dataManagerEmployees.getEmployeesByTeam(Employee.UNASSIGNED_TEAM));
        model.addAttribute("TeamName", teamName);

        return "/teamModifySelectedTeam";
    }

    @PostMapping("/teamModifySelectedTeam/add/{oldTeamName}")
    public String changeTeamName(@RequestParam(name = "newTeamName", required = false) String newTeamName,
                                 @PathVariable(name = "oldTeamName") String oldTeamName, Model model) {

        dataManagerEmployees.changeTeamName(oldTeamName, newTeamName);
        dataManagerTeams.renameTeam(oldTeamName, newTeamName);

        model.addAttribute("AllTeamEmployees", dataManagerEmployees.getEmployeesByTeam(newTeamName));
        model.addAttribute("AllUnassignedEmployees", dataManagerEmployees.getEmployeesByTeam(Employee.UNASSIGNED_TEAM));
        model.addAttribute("TeamName", newTeamName);
        return "teamModifySelectedTeam";
    }
}




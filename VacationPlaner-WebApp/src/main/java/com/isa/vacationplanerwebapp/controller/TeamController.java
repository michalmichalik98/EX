package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.dataManager.DataManagerTeams;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Team;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeamController {
    private final DataManagerTeams dataManagerTeams;
    private final DataManagerEmployees dataManagerEmployees;

    private static final Logger logger = LogManager.getLogger(TeamController.class);

    @Autowired
    public TeamController(DataManagerTeams dataManagerTeams, DataManagerEmployees dataManagerEmployees) {
        this.dataManagerTeams = dataManagerTeams;
        this.dataManagerEmployees = dataManagerEmployees;
        logger.info("Initialized TeamController with DataManagerTeams and DataManagerEmployees");
    }

    @GetMapping("/teamAdd")
    public String addTeam(Model model) {
        Team team = new Team();
        model.addAttribute("teamKeyAdd", team);
        logger.info("Received request for adding team");
        return "teamAdd";
    }

    @PostMapping("/teamAdd")
    public String addTeamRequest(@Valid Team team, BindingResult result) {
        if (result.hasErrors()) {
            logger.warn("Validation errors occurred while adding team");
            return "teamAdd";
        }
        dataManagerTeams.addTeam(team);
        logger.info("Added new team with name {}", team.getTeamName());
        return "redirect:/teamList";
    }

    @GetMapping("/teamDelete")
    public String deleteTeam(Model model) {
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        logger.info("Received request for deleting team");
        return "/teamDelete";
    }

    @GetMapping("/teamDelete/{teamName}")
    public String deleteTeamRequest(@PathVariable( name = "teamName") String teamName) {
        dataManagerTeams.deleteTeam(teamName);
        dataManagerEmployees.removeAllEmployeesFromTeam(teamName);
        logger.info("Deleted team with name {} from DataManagerTeams and all the employees from the team", teamName);
        return "redirect:/teamDelete";
    }

    @GetMapping("/teamModify")
    public String modifyTeam(Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        model.addAttribute("teamKeyModify", new Team());
        logger.info("Received request for modifying team");
        return "teamModify";
    }


    @GetMapping("/teamList")
    public String listOfTeams(Model model) {
        model.addAttribute("AllTeams", dataManagerTeams.getTeams());
        logger.info("Received request for team list");
        return "teamList";
    }

    @GetMapping("/teamModifySelectedTeam/{teamName}")
    public String SelectedTeamModify(@PathVariable(name = "teamName") String teamName, Model model) {

        model.addAttribute("AllTeamEmployees", dataManagerEmployees.getEmployeesByTeam(teamName));
        model.addAttribute("AllUnassignedEmployees", dataManagerEmployees.getEmployeesByTeam(Employee.UNASSIGNED_TEAM));
        model.addAttribute("TeamName", teamName);
        logger.info("Received request for modifying the selected team {}", teamName);
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
        logger.info("Deleted team member with id: " + id + " from team: " + teamName);
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
        logger.info("Added team member with id: " + id + " to team: " + teamName);
        return "/teamModifySelectedTeam";
    }

    @PostMapping("/teamModifySelectedTeam/add/{oldTeamName}")
    public String changeTeamName(@RequestParam(name = "newTeamName", required = false) String newTeamName,
                                 @PathVariable(name = "oldTeamName") String oldTeamName, Model model) {

        dataManagerEmployees.changeTeamName(oldTeamName, newTeamName);
        dataManagerTeams.renameTeam(oldTeamName, newTeamName);
        logger.info("Changed team name from: " + oldTeamName + " to: " + newTeamName);
        model.addAttribute("AllTeamEmployees", dataManagerEmployees.getEmployeesByTeam(newTeamName));
        model.addAttribute("AllUnassignedEmployees", dataManagerEmployees.getEmployeesByTeam(Employee.UNASSIGNED_TEAM));
        model.addAttribute("TeamName", newTeamName);
        return "teamModifySelectedTeam";
    }
}




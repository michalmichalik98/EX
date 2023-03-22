package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.dataManager.DataManagerTeams;
import com.isa.vacationplanerwebapp.dataManager.DataManagerVacation;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Vacation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VacationController {

    private final DataManagerEmployees dataManagerEmployees;
    private final DataManagerVacation dataManagerVacation;
    private final DataManagerTeams dataManagerTeams;


    public static Logger logger = LogManager.getLogger(VacationController.class);

    public VacationController(DataManagerEmployees dataManagerEmployees, DataManagerVacation dataManagerVacation, DataManagerTeams dataManagerTeams ) {
        this.dataManagerEmployees = dataManagerEmployees;
        this.dataManagerVacation = dataManagerVacation;
        this.dataManagerTeams = dataManagerTeams;
    }

    @GetMapping("/vacationAdd")
    public String MainVacationAdd(Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("Employee", new Employee());
        model.addAttribute("Vacation", new Vacation());
        logger.info("Displaying vacation add page");
        return "/vacationAdd";
    }

    @GetMapping("/vacationAdd/{Id}")
    public String VacationAddToEmployee(@PathVariable(name = "Id", required = false) String Id, Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("Employee", dataManagerEmployees.getEmployeeById(Id));
        model.addAttribute("Vacation", new Vacation());
        logger.info("Displaying vacation add page for employee with ID {}", Id);
        return "/vacationAdd";
    }

    @PostMapping("/vacationAdd/{id}")
    public String VacationAdd(Vacation vacation, @PathVariable(name = "id", required = false) String id){
     /*   if(vacation.getStart().isEmpty() || vacation.getStop().isEmpty()){
            return "redirect:/vacationAdd";
        }*/
        vacation.setEmployeeID(id);
        vacation.setName(dataManagerEmployees.getEmployeeById(id).getName());
        vacation.setSurname(dataManagerEmployees.getEmployeeById(id).getSurname());
        dataManagerVacation.addVacation(vacation);
        logger.info("Added vacation for employee with ID {}", id);
        return "redirect:/vacationModify";
    }
    @PostMapping("/vacationAdd/")
    public String noEmployeeFilledSubmit(Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("Employee", new Employee());
        model.addAttribute("Vacation", new Vacation());
        logger.info("Displaying vacation add page");
        return "/vacationAdd";
    }


    @GetMapping("/vacationDelete")
    public String getVacationDelete(Model model) {
        model.addAttribute("AllVacation",dataManagerVacation.getAllVacations());
        logger.info("Displaying vacation delete page");
        return "/vacationDelete";
    }

    @GetMapping("/vacationDelete/{id}")
    public String VacationAdd( @PathVariable(name = "id", required = false) String id) {
        dataManagerVacation.deleteVacation(id);
        logger.info("Deleting vacation with ID {}", id);
        return "redirect:/vacationDelete";
    }

    @GetMapping("/vacationModify")
    public String modifyVacation(Model model) {

        model.addAttribute("AllVacation", dataManagerVacation.getAllVacations());
        model.addAttribute("Vacation", new Vacation());
        logger.info("Received request to modify vacation");
        return "/vacationModify";
    }

    @GetMapping("/vacationModify/{id}")
    public String modifyVacationSelected(Model model, @PathVariable(name = "id", required = false) String id) {

        model.addAttribute("AllVacation", dataManagerVacation.getAllVacations());
        model.addAttribute("Vacation", dataManagerVacation.getVacationById(id));
        logger.info("Received request to modify vacation with ID: " + id);
        return "/vacationModify";
    }

    @PostMapping("/vacationModify")
    public String vacationModify(Vacation vacation){

        dataManagerVacation.modifyVacation(vacation);
        logger.info("Modifying vacation with id: " + vacation.getVacationId());
        return "redirect:/vacationModify";
    }

    @GetMapping("/vacationList")
    public String getVacationList(Model model) {

        model.addAttribute("TeamEmployeeMap", dataManagerEmployees.groupEmployeesByTeam());
        model.addAttribute("AllVacation", dataManagerVacation.getAllVacations());
        logger.info("Retrieving vacation list.");
        return "/vacationList";
    }


}

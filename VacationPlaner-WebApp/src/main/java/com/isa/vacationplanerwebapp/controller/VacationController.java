package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.dataManager.DataManagerVacation;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Vacation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class VacationController {

    private final DataManagerEmployees dataManagerEmployees;
    private final DataManagerVacation dataManagerVacation;

    public VacationController(DataManagerEmployees dataManagerEmployees, DataManagerVacation dataManagerVacation) {
        this.dataManagerEmployees = dataManagerEmployees;
        this.dataManagerVacation = dataManagerVacation;
    }

    @GetMapping("/vacationAdd")
    public String MainVacationAdd(Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("Employee", new Employee());
        model.addAttribute("Vacation", new Vacation());
        return "/vacationAdd";
    }

    @GetMapping("/vacationAdd/{Id}")
    public String VacationAddToEmployee(@PathVariable(name = "Id", required = false) String Id, Model model) {
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("Employee", dataManagerEmployees.getEmployeeById(Id));
        model.addAttribute("Vacation", new Vacation());
        return "/vacationAdd";
    }

    @PostMapping("/vacationAdd/{id}")
    public String VacationAdd(Vacation vacation, @PathVariable(name = "id", required = false) String id){
        dataManagerVacation.creatVEvent(vacation, id);

        return "redirect:/index";
    }


    @GetMapping("/vacationDelete")
    public String getVacationDelete() {
        return "/vacationDelete";
    }

    @GetMapping("/vacationModify")
    public String getVacationModify() {
        return "/vacationModify";
    }

    @GetMapping("/vacationList")
    public String getVacationList() {
        return "/vacationList";
    }


}

package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EmployeeController {

    private final DataManagerEmployees dataManagerEmployees;

    public EmployeeController(DataManagerEmployees dataManagerEmployees) {
        this.dataManagerEmployees = dataManagerEmployees;
    }

    @GetMapping("/index")
    public String getIndex(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/index";
    }
}

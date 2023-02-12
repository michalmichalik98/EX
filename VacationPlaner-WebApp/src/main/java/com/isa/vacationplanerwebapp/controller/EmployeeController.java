package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final DataManagerEmployees dataManagerEmployees;

    @Autowired
    public EmployeeController(DataManagerEmployees dataManagerEmployees) {
        this.dataManagerEmployees = dataManagerEmployees;
    }

    @GetMapping ("/employeeAdd.html")
    public String getAddEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee );
        return "employeeAdd.html";
    }
    @PostMapping("/employeeAdd.html")
    public String getAddEmployee2(@ModelAttribute Employee employee) {
        dataManagerEmployees.addEmployee(employee);
        return "redirect:/employeeAdd.html";
    }

    @GetMapping("/index")
    public String getEmployee(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/index";
    }
}

package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {

    private final DataManagerEmployees dataManagerEmployees;

    @Autowired
    public EmployeeController(DataManagerEmployees dataManagerEmployees) {
        this.dataManagerEmployees = dataManagerEmployees;
    }

    @GetMapping("/employeeAdd")
    public String AddEmployee(Model model, @RequestParam(name = "Id", required = false) String Id) {
        Employee employee = new Employee();
        System.out.println(Id);
        model.addAttribute("employee", employee);
        return "employeeAdd";
    }

    @PostMapping("/employeeAdd")
    public String AddEmployeeRequest(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employeeAdd";
        }
        dataManagerEmployees.addEmployee(employee);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String getIndex(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/index";
    }

    @GetMapping("/employeeDelete")
    public String deleteEmployee(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/employeeDelete";
    }

    @GetMapping("/employeeDelete/{id}/")
    public String deleteEmployeeRequest(@RequestParam String id) {
        dataManagerEmployees.deleteEmployee(id);
        return "redirect:/employeeDelete";
    }
}

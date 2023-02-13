package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.model.Employee;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class EmployeeController {

    private final DataManagerEmployees dataManagerEmployees;
    @Autowired
    public EmployeeController(DataManagerEmployees dataManagerEmployees) {
        this.dataManagerEmployees = dataManagerEmployees;
    }



    @GetMapping("/index")
    public String getIndex(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/index";
    }


    @GetMapping("/employeeAdd")
    public String addEmployee(Model model, @RequestParam(name = "Id", required = false) String Id) {
        Employee employee = new Employee();
        model.addAttribute("employeeKeyAdd", employee);
        return "employeeAdd";
    }
    @PostMapping("/employeeAdd")
    public String addEmployeeRequest(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return "employeeAdd";
        }
        dataManagerEmployees.addEmployee(employee);
        return "redirect:/index";
    }


    @GetMapping("/employeeDelete")
    public String deleteEmployee(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/employeeDelete";
    }
    @GetMapping("/employeeDelete/{id}")
    public String deleteEmployeeRequest(@PathVariable(required = false, name="id") String id) {
        dataManagerEmployees.deleteEmployee(id);
        return "redirect:/employeeDelete";
    }


    @GetMapping("/employeeModify")
    public String modifyEmployee(Model model) {

        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());

        model.addAttribute("employeeKeyModify", new Employee());
        return "/employeeModify";
    }
    @GetMapping("/employeeModify/{id}")
    public String displayEmployeeToModify(@PathVariable(required = false, name="id") String id, Model model) {

        model.addAttribute("employeeKeyModify", dataManagerEmployees.getEmployeeById(id));
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());

        return "employeeModify";
    }
    @PostMapping("/employeeModify")
    public String ModifyEmployeeRequest( Employee employee) {
        dataManagerEmployees.modifyEmployee(employee);
        return "redirect:/employeeModify";
    }

}

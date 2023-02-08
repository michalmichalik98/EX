package com.isa.vacationplanerwebapp;

import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {


    @GetMapping("/index")
    public String addEmployees(Model model){
        Employee employee = new Employee();
        model.addAttribute("book", employee);
        return "3";
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        return "redirect:/index/";
    }
}

package com.isa.vacationplanerwebapp;

import com.isa.vacationplanerwebapp.dataManager.DataManager;
import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmployeeController {

    private final DataManager dataManager;
    @Autowired
    public EmployeeController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @GetMapping("/index")
    String addEmployees(Model model){
        Employee employee = new Employee();
        dataManager.test();

        model.addAttribute("employee", employee);
        return "index";
    }


    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        return "redirect:/index/";
    }
}

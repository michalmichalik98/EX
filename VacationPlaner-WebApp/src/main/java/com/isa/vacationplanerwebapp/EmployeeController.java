package com.isa.vacationplanerwebapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final DataManager dataManager;
    @Autowired
    public EmployeeController(DataManager dataManager) {
        this.dataManager = dataManager;
    }

    @GetMapping("/")
    String employees(){
        return dataManager.displeyEmployeeList().toString();
    }

}

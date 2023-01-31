package com.isa.vacationplanerwebapp;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataManager2 {
    List<String> displeyEmployeeList(){
        return List.of("a","b","c");
    }

}

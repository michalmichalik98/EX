package com.isa.vacationplanerwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThemController {

    @GetMapping("/index")
    public String getIndex() {
        return "/index";
    }

    @GetMapping("/css/styles.css")
    public String getCSS() {
        return "/css/styles.css";
    }

    @GetMapping("/assets/demo/chart-area-demo.js")
    public String getChartArea() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/assets/demo/chart-bar-demo.js")
    public String getCharBar() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/js/datatables-simple-demo.js")
    public String getDataTable() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/js/scripts.js")
    public String getJScripts() {
        return "/js/scripts.js";
    }

    @GetMapping("/employeeAdd.html")
    public String getAddEmployee() {
        return "/employeeAdd.html";
    }

    @GetMapping("/employeeModify.html")
    public String getEmployeeModify() {
        return "/employeeModify.html";
    }

    @GetMapping("/employeeDelete.html")
    public String getEmployeeDelete() {
        return "/employeeDelete.html";
    }

    @GetMapping("/employeeList.html")
    public String getEmployeeList() {
        return "/employeeList.html";
    }

    @GetMapping("/teamDelete.html")
    public String getTeamDelete() {
        return "/teamDelete.html";
    }

    @GetMapping("/teamAdd.html")
    public String getTeamAdd() {
        return "/teamAdd.html";
    }

    @GetMapping("/teamModify.html")
    public String getTeamModify() {
        return "/teamModify.html";
    }

    @GetMapping("/teamList.html")
    public String getTeamList() {
        return "/teamList.html";
    }

    @GetMapping("/vacationDelete.html")
    public String getVacationDelete() {
        return "/vacationDelete.html";
    }

    @GetMapping("/vacationAdd.html")
    public String getVacationAdd() {
        return "/vacationAdd.html";
    }

    @GetMapping("/vacationModify.html")
    public String getVacationModify() {
        return "/vacationModify.html";
    }

    @GetMapping("/vacationList.html")
    public String getVacationList() {
        return "/vacationList.html";
    }
}
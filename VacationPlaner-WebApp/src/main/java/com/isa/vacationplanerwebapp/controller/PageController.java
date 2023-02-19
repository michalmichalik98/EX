package com.isa.vacationplanerwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {


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

    @GetMapping("/employeeModify/css/styles.css")
    public String getCssEmployee() {
        return "/css/styles.css";
    }

    @GetMapping("/employeeModify/assets/demo/chart-area-demo.js")
    public String getChartAreaEmployee() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/employeeModify/assets/demo/chart-bar-demo.js")
    public String getCharBarEmployee() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/employeeModify/js/datatables-simple-demo.js")
    public String getDataTableEmployee() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/employeeModify/js/scripts.js")
    public String getJScriptsEmployee() {
        return "/js/scripts.js";
    }


    @GetMapping("/teamDelete")
    public String getTeamDelete() {
        return "/teamDelete";
    }

    @GetMapping("/teamAdd")
    public String getTeamAdd() {
        return "/teamAdd";
    }

    @GetMapping("/teamModify")
    public String getTeamModify() {
        return "/teamModify";
    }

    @GetMapping("/teamList")
    public String getTeamList() {
        return "/teamList";
    }

    @GetMapping("/vacationDelete")
    public String getVacationDelete() {
        return "/vacationDelete";
    }

    @GetMapping("/vacationAdd")
    public String getVacationAdd() {
        return "/vacationAdd";
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
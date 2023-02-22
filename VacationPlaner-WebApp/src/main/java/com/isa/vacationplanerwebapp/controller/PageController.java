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
    public String getDeleteTeam() {
        return "/teamDelete";
    }


    @GetMapping("/teamModify")
    public String getModifyTeam() {
        return "/teamModify";
    }

    @GetMapping("/teamList")
    public String getTeamListTeam() {
        return "/teamList";
    }

    @GetMapping("/addTeam/assets/demo/chart-area-demo.js")
    public String getChartAreaTeam() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/addTeam/assets/demo/chart-bar-demo.js")
    public String getCharBarTeam() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/addTeam/js/datatables-simple-demo.js")
    public String getDataTableTeam() {
        return "/js/datatables-simple-demo.js";
    }


    @GetMapping("/vacationAdd/css/styles.css")
    public String getCSSVacation() {
        return "/css/styles.css";
    }

    @GetMapping("/vacationAdd/assets/demo/chart-area-demo.js")
    public String getChartAreaVacation() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/vacationAdd/assets/demo/chart-bar-demo.js")
    public String getCharBarVacation() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/vacationAdd/js/datatables-simple-demo.js")
    public String getDataTableVacation() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/vacationAdd/js/scripts.js")
    public String getJScriptsVacation() {
        return "/js/scripts.js";
    }

}
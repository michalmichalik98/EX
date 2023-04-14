package com.isa.vacationplanerwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

    @GetMapping("/login")
    public String getLogin() {
        return "/login";
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

    @GetMapping("/teamModifySelectedTeam/css/styles.css")
    public String getCssTeamModSelected() {
        return "/css/styles.css";
    }

    @GetMapping("/teamModifySelectedTeam/assets/demo/chart-area-demo.js")
    public String getChartAreaTeamModSelected() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/assets/demo/chart-bar-demo.js")
    public String getCharBarTeamModSelected() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/js/datatables-simple-demo.js")
    public String getDataTableTeamModSelected() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/js/scripts.js")
    public String getJScriptsTeamModSelected() {
        return "/js/scripts.js";
    }


    @GetMapping("/teamModifySelectedTeam/delete/{}/css/styles.css")
    public String getCssTeamModDelete() {
        return "/css/styles.css";
    }

    @GetMapping("/teamModifySelectedTeam/delete/{}/assets/demo/chart-area-demo.js")
    public String getChartAreaTeamModDelete() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/delete/{}/assets/demo/chart-bar-demo.js")
    public String getCharBarTeamModDelete() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/delete/{}/js/datatables-simple-demo.js")
    public String getDataTableTeamModDelete() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/delete/{}/js/scripts.js")
    public String getJScriptsTeamModDelete() {
        return "/js/scripts.js";
    }


    @GetMapping("/teamModifySelectedTeam/delete/css/styles.css")
    public String getCssTeamModDeleteMain() {
        return "/css/styles.css";
    }

    @GetMapping("/teamModifySelectedTeam/delete/assets/demo/chart-area-demo.js")
    public String getChartAreaTeamModDeleteMain() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/delete/assets/demo/chart-bar-demo.js")
    public String getCharBarTeamModDeleteMain() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/delete/js/datatables-simple-demo.js")
    public String getDataTableTeamModDeleteMain() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/delete/js/scripts.js")
    public String getJScriptsTeamModDeleteMain() {
        return "/js/scripts.js";
    }


    @GetMapping("/teamModifySelectedTeam/add/{}/css/styles.css")
    public String getCssTeamModAdd() {
        return "/css/styles.css";
    }

    @GetMapping("/teamModifySelectedTeam/add/{}/assets/demo/chart-area-demo.js")
    public String getChartAreaTeamModAdd() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/add/{}/assets/demo/chart-bar-demo.js")
    public String getCharBarTeamModAdd() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/add/{}/js/datatables-simple-demo.js")
    public String getDataTableTeamModAdd() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/add/js/scripts.js")
    public String getJScriptsTeamModAddMain() {
        return "/js/scripts.js";
    }

    @GetMapping("/teamModifySelectedTeam/add/css/styles.css")
    public String getCssTeamModAddMain() {
        return "/css/styles.css";
    }

    @GetMapping("/teamModifySelectedTeam/add/assets/demo/chart-area-demo.js")
    public String getChartAreaTeamModMain() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/add/assets/demo/chart-bar-demo.js")
    public String getCharBarTeamModAddMain() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/teamModifySelectedTeam/add/js/datatables-simple-demo.js")
    public String getDataTableTeamModAddMain() {
        return "/js/datatables-simple-demo.js";
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


    @GetMapping("/vacationModify/assets/demo/chart-area-demo.js")
    public String getChartAreaVacationModify() {
        return "/assets/demo/chart-area-demo.js";
    }

    @GetMapping("/vacationModify/assets/demo/chart-bar-demo.js")
    public String getCharBarVacationModify() {
        return "/assets/demo/chart-bar-demo.js";
    }

    @GetMapping("/vacationModify/js/datatables-simple-demo.js")
    public String getDataTableVacationModify() {
        return "/js/datatables-simple-demo.js";
    }

    @GetMapping("/vacationModify/js/scripts.js")
    public String getJScriptsVacationModify() {
        return "/js/scripts.js";
    }

    @GetMapping("/vacationModify/css/styles.css")
    public String getCssVacationModify() {
        return "/css/styles.css";
    }


}
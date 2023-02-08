package com.isa.vacationplanerwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThemController {
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

}
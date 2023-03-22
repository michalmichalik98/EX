package com.isa.vacationplanerwebapp.controller;

import com.isa.vacationplanerwebapp.dataManager.DataManagerEmployees;
import com.isa.vacationplanerwebapp.model.Employee;
import jakarta.validation.Valid;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
    private static final Logger logger = LogManager.getLogger(EmployeeController.class);

    @Autowired
    public EmployeeController(DataManagerEmployees dataManagerEmployees) {
        this.dataManagerEmployees = dataManagerEmployees;
    }



    @GetMapping("/index")
    public String getIndex(Model model) {
        logger.info("GET /index - main page");
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/index";
    }


    @GetMapping("/employeeAdd")
    public String addEmployee(Model model, @RequestParam(name = "Id", required = false) String Id) {
        logger.info("GET /employeeAdd - adding new employee");
        Employee employee = new Employee();
        model.addAttribute("employeeKeyAdd", employee);
        return "employeeAdd";
    }
    @PostMapping("/employeeAdd")
    public String addEmployeeRequest(@Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            logger.warn("POST /employeeAdd - failed to add new employee - invalid data");
            return "employeeAdd";
        }
        dataManagerEmployees.addEmployee(employee);
        logger.info("POST /employeeAdd - new employee added successfully");
        return "redirect:/index";
    }


    @GetMapping("/employeeDelete")
    public String deleteEmployee(Model model) {
        logger.debug("Entered deleteEmployee method");
        model.addAttribute("AllEmployee", dataManagerEmployees.getEmployees());
        return "/employeeDelete";
    }
    @GetMapping("/employeeDelete/{id}")
    public String deleteEmployeeRequest(@PathVariable(required = false, name="id") String id) {
        logger.debug("Deleting employee with id {}", id);
        dataManagerEmployees.deleteEmployee(id);
        logger.debug("Redirecting to /employeeDelete");
        return "redirect:/employeeDelete";
    }


    @GetMapping("/employeeModify")
    public String modifyEmployee(Model model) {
        logger.info("Entering modifyEmployee method");
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        model.addAttribute("employeeKeyModify", new Employee());
        logger.info("Leaving modifyEmployee method");
        return "/employeeModify";
    }
    @GetMapping("/employeeModify/{id}")
    public String displayEmployeeToModify(@PathVariable(required = false, name="id") String id, Model model) {
        logger.info("Entering displayEmployeeToModify method with id = {}", id);
        model.addAttribute("employeeKeyModify", dataManagerEmployees.getEmployeeById(id));
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        logger.info("Leaving displayEmployeeToModify method");
        return "employeeModify";
    }
    @PostMapping("/employeeModify")
    public String ModifyEmployeeRequest( Employee employee) {
        logger.info("Entering ModifyEmployeeRequest method with employee = {}", employee);
        dataManagerEmployees.modifyEmployee(employee);
        logger.info("Leaving ModifyEmployeeRequest method");
        return "redirect:/employeeModify";
    }

    @GetMapping("/employeeList")
    public String ListOfEmployees(Model model) {
        logger.info("Fetching all employees");
        model.addAttribute("AllEmployees", dataManagerEmployees.getEmployees());
        return "/employeeList";
    }
}

package com.isa.vacationplanerwebapp.model;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Calendar {
    private ArrayList<Employee> employees = new ArrayList<Employee>();
    private ArrayList<Team> teams = new ArrayList<Team>();
    private ArrayList<Holiday> holidays = new ArrayList<Holiday>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private String sortOrder = "ASC";

    public Calendar() {
        loadEmployees();
        loadTeams();
        loadHolidays();
        loadConfig();
    }

    public void loadEmployees() {
        // load employee data from file
    }

    public void loadTeams() {
        // load team data from file
    }

    public void loadHolidays() {
        // load holiday data from API or file
    }

    public void loadConfig() {
        // load config data from file
    }

    public void addEmployee(String name, String team) {
        // add employee to employees list and team
    }

    public void removeEmployee(String name) {
        // remove employee from employees list and team
    }

    public void addHoliday(String employee, Date startDate, Date endDate) {
        // add holiday to employee's holiday list
    }

    public void removeHoliday(String employee, Date startDate) {
        // remove holiday from employee's holiday list
    }

    public void setSortOrder(String order) {
        sortOrder = order;
    }

    public void setDateFormat(String format) {
        dateFormat = new SimpleDateFormat(format);
    }

    public void showHolidays() {
        // display all holidays
    }

    public void showHoliday(String name) {
        // display holiday by name
    }

    public void showEmployeeHolidays(String name) {
        // display all holidays for employee
    }

    public void showTeamHolidays(String name) {
        // display all holidays for team
    }

    public void showHolidays(String team, Date start, Date end) {
        // display all holidays for team within date range
    }

    public void saveChanges() {
        // save changes to employee and team data to file
    }
}

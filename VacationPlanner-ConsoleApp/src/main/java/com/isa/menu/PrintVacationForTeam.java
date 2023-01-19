package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;
import com.isa.model.Team;
import com.isa.model.Vacation;

import java.util.ArrayList;

public class PrintVacationForTeam {
    public void print() {

        ArrayList<Employee> employee = new ArrayList<>();
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Vacation> vacations = new ArrayList<>();

        Team team1 = new Team();
        Team team2 = new Team();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();
        Employee employee3 = new Employee();
        Employee employee4 = new Employee();

        team1.setTeamName("luzblue1");
        team2.setTeamName("luzblue2");

        DataManager.addTeam(team1);
        DataManager.addTeam(team2);


        teams.add(team1);
        teams.add(team2);

        DataManager.loadEmployeeFromFile();
        employee = DataManager.employeeList;



        employee1.setEmployeeId(1);
        employee2.setEmployeeId(1);
        employee3.setEmployeeId(2);
        employee4.setEmployeeId(2);

        Vacation vacation1 = new Vacation();
        Vacation vacation2 = new Vacation();
        Vacation vacation3 = new Vacation();
        Vacation vacation4 = new Vacation();
        Vacation vacation5 = new Vacation();
        Vacation vacation6 = new Vacation();
        Vacation vacation7 = new Vacation();
        Vacation vacation8 = new Vacation();

        vacation1.setVacationId(1);
        vacation2.setVacationId(2);
        vacation3.setVacationId(3);
        vacation4.setVacationId(4);
        vacation5.setVacationId(5);
        vacation6.setVacationId(6);
        vacation7.setVacationId(7);
        vacation8.setVacationId(8);

        employee1.setVacationId(1);
        employee1.setVacationId(2);
        employee2.setVacationId(3);
        employee2.setVacationId(4);
        employee3.setVacationId(5);
        employee3.setVacationId(6);
        employee4.setVacationId(7);
        employee4.setVacationId(8);

        }
}



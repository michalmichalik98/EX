package com.isa.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Team {
    private String teamName;
    private Integer employeeId;
   private Employee[] employees = new Employee[5];



    public void consoleTeamData() {
        Team team = new Team();
        team.setTeamName(teamName);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj nazwę zespołu");
        teamName = scanner.nextLine();
    }


    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Team() {
        this.teamName = teamName;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", employees=" + Arrays.toString(employees) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return Objects.equals(teamName, team.teamName) && Arrays.equals(employees, team.employees);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(teamName);
        result = 31 * result + Arrays.hashCode(employees);
        return result;
    }
}

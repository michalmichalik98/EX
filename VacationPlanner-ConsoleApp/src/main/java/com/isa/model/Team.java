package com.isa.model;

import com.isa.model.Employee;

import java.util.Arrays;
import java.util.Objects;

public class Team {
    private String teamName;
    private Employee[] employees = new Employee[5];

    public Team(String teamName, Employee[] employees) {
        this.teamName = teamName;
        this.employees = employees;
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

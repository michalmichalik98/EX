package com.isa.vacationplanerwebapp.model;

import jakarta.validation.constraints.NotEmpty;

import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public class Employee {

    @NotEmpty
    private String name;
    private String surname;
    private String pesel;
    private String email;
    private Address address;
    private String phoneNumber;
    private String team;
    private String employeeId;

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Employee(String name, String surname, String pesel, String email, Address address, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.pesel = pesel;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.team = "UnAssignedTeam";
        this.employeeId = UUID.randomUUID().toString();
    }

    public Employee() {
        team = "UnAssignedTeam";
    }
    public String getTeam() {
        return team;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId.add(vacationId);
    }

    public String getPesel() {
        return pesel;
    }

    private ArrayList<Integer> vacationId;

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee employee)) return false;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname)
                && Objects.equals(pesel, employee.pesel) && Objects.equals(email, employee.email)
                && Objects.equals(address, employee.address) && Objects.equals(phoneNumber, employee.phoneNumber)
                && Objects.equals(team, employee.team) && Objects.equals(employeeId, employee.employeeId)
                && Objects.equals(vacationId, employee.vacationId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, pesel, email, address, phoneNumber, team, employeeId, vacationId);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", secondName='" + surname + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}



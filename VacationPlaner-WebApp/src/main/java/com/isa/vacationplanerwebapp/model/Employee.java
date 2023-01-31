package com.isa.vacationplanerwebapp.model;

import java.util.ArrayList;
import java.util.Objects;

public class Employee {
    private String name;
    private String surname;
    private String pesel;
    private String email;
    private String address;
    private String phoneNumber;
    private String team;
    private Integer eployeeId;
    private ArrayList<Integer> vacationId;

    public Employee(){
        team = "UnAssignedTeam";
    }

    public String getTeam() {
        return team;
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

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmployeeId(Integer eployeeId) {
        this.eployeeId = eployeeId;
    }
    public Integer getEmployeeId() {
        return eployeeId;
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
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(surname, employee.surname) && Objects.equals(pesel, employee.pesel) && Objects.equals(email, employee.email) && Objects.equals(address, employee.address) && Objects.equals(phoneNumber, employee.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, pesel, email, address, phoneNumber);
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



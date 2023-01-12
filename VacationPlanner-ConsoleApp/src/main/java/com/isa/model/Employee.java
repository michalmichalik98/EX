package com.isa.model;

import java.util.ArrayList;

public class Employee {
    private String name;
    private String secondName;
    private String pesel;
    private String email;
    private String address;
    private String phoneNumber;
    private ArrayList<Holiday> holidays = new ArrayList<Holiday>();
    private Team team;

    public Employee(String name, String secondName, String pesel, String email, String address, String phoneNumber, ArrayList<Holiday> holidays, Team team) {
        this.name = name;
        this.secondName = secondName;
        this.pesel = pesel;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.holidays = holidays;
        this.team = team;
    }

    public void addHoliday(Holiday holiday) {
        holidays.add(holiday);
    }

    public void removeHoliday(Holiday holiday) {
        holidays.remove(holiday);
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}



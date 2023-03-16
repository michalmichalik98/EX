package com.isa.vacationplanerwebapp.model;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Vacation {

    private LocalDate start;
    private LocalDate stop;
    private TypeOfVacation vacationType;
    private String employeeID;
    private String name;
    private String surname;
    private String vacationId;

    public Vacation() {
       this.vacationId = UUID.randomUUID().toString();
    }

    public Vacation(LocalDate start, LocalDate stop, TypeOfVacation vacationType, String employeeID, String name, String surname) {
        this.start = start;
        this.stop = stop;
        this.vacationType = vacationType;
        this.employeeID = employeeID;
        this.name = name;
        this.surname = surname;
        this.vacationId = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getVacationId() {
        return vacationId;
    }

    public void setVacationId(String vacationId) {
        this.vacationId = vacationId;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getStop() {
        return stop;
    }

    public void setStop(LocalDate stop) {
        this.stop = stop;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public TypeOfVacation getVacationType() {
        return vacationType;
    }

    public void setVacationType(TypeOfVacation vacationType) {
        this.vacationType = vacationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacation vacation)) return false;
        return Objects.equals(start, vacation.start) && Objects.equals(stop, vacation.stop) && Objects.equals(vacationType, vacation.vacationType) && Objects.equals(employeeID, vacation.employeeID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, stop, vacationType, employeeID, name, surname, vacationId);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "start=" + start +
                ", stop=" + stop +
                ", vacationType=" + vacationType +
                ", employeeID='" + employeeID + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", vacationId='" + vacationId + '\'' +
                '}';
    }
}


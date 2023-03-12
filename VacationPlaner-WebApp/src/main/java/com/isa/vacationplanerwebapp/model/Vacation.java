package com.isa.vacationplanerwebapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vacation {

    private LocalDate start;
    private LocalDate stop;
    private TypeOfVacation vacationType;
    private String employeeID;

    public Vacation() {
    }

    public Vacation(LocalDate start, LocalDate stop, TypeOfVacation vacationType, String employeeID) {
        this.start = start;
        this.stop = stop;
        this.vacationType = vacationType;
        this.employeeID = employeeID;
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
        return Objects.hash(start, stop, vacationType, employeeID);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "start=" + start +
                ", stop=" + stop +
                ", vacationType='" + vacationType + '\'' +
                ", employeeID='" + employeeID + '\'' +
                '}';
    }


}


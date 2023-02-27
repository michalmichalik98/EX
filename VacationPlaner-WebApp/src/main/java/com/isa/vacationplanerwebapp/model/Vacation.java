package com.isa.vacationplanerwebapp.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vacation {

    String start;
    String stop;
    String summary;
    String vacationType;

    public Vacation() {
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getStop() {
        return stop;
    }

    public void setStop(String stop) {
        this.stop = stop;
    }

    public String getVacationType() {
        return vacationType;
    }

    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vacation vacation)) return false;
        return Objects.equals(start, vacation.start) && Objects.equals(stop, vacation.stop) && Objects.equals(summary, vacation.summary) && Objects.equals(vacationType, vacation.vacationType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, stop, summary, vacationType);
    }

    @Override
    public String toString() {
        return "Vacation{" +
                "start=" + start +
                ", stop=" + stop +
                ", summary='" + summary + '\'' +
                ", vacationType='" + vacationType + '\'' +
                '}';
    }
}
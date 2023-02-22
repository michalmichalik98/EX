package com.isa.vacationplanerwebapp.model;


import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.property.Summary;

import java.util.Objects;

public class Vacation {

    DateTime start;
    DateTime stop;
    Summary summary;
    String vacationType;


    public Vacation() {
    }

    public DateTime getStart() {
        return start;
    }

    public void setStart(DateTime start) {
        this.start = start;
    }

    public DateTime getStop() {
        return stop;
    }

    public void setStop(DateTime stop) {
        this.stop = stop;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
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
}
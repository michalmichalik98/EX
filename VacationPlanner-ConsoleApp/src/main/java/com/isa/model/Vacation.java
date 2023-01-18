package com.isa.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vacation {

    private Integer vacationId;



    LocalDate date = LocalDate.parse("2022-12-04");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Objects.equals(date, vacation.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(date);
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId = vacationId;
    }

    public Integer getVacationId() {
        return vacationId;
    }
}

package com.isa.model;

import java.time.LocalDate;
import java.util.Objects;

public class Vacation {

    private Integer vacationId;
    LocalDate startDate = LocalDate.parse("2022-12-04");
    LocalDate endDate = LocalDate.parse("2022-12-04");

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vacation vacation = (Vacation) o;
        return Objects.equals(startDate, vacation.startDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDate);
    }

    public void setVacationId(Integer vacationId) {
        this.vacationId = vacationId;
    }

    public Integer getVacationId() {
        return vacationId;
    }
}

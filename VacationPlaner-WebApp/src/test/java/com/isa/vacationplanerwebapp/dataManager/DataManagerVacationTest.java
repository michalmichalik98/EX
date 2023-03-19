package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.exception.EmployeeNotFoundException;
import com.isa.vacationplanerwebapp.model.TypeOfVacation;
import com.isa.vacationplanerwebapp.model.Vacation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class DataManagerVacationTest {

    private DataManagerVacation dataManagerVacation;

    @BeforeEach
    void before() {
        dataManagerVacation = new DataManagerVacation();
    }

    @Test
    void getAllVacationsTest() {
        List<Vacation> allVacations = dataManagerVacation.getAllVacations();
        assertThat(allVacations).hasSize(9);
    }

    @Test
    void addVacationTest() {
        LocalDate start = LocalDate.now().plusDays(1);
        LocalDate end = LocalDate.now().plusDays(5);
        Vacation vacation = new Vacation(start, end, TypeOfVacation.HOLIDAY, "testId", "John", "Doe");
        dataManagerVacation.addVacation(vacation);
        List<Vacation> allVacations = dataManagerVacation.getAllVacations();
        assertThat(allVacations).hasSize(10);
        assertThat(allVacations).contains(vacation);
    }

    @Test
    void deleteVacationTest() {
        String vacationId = dataManagerVacation.getAllVacations().get(0).getVacationId();
        dataManagerVacation.deleteVacation(vacationId);
        List<Vacation> allVacations = dataManagerVacation.getAllVacations();
        assertThat(allVacations).hasSize(8);
        assertThatThrownBy(() -> dataManagerVacation.getVacationById(vacationId))
                .isInstanceOf(EmployeeNotFoundException.class);
    }

    @Test
    void getVacationByIdTest() {
        String vacationId = dataManagerVacation.getAllVacations().get(0).getVacationId();
        Vacation vacation = dataManagerVacation.getVacationById(vacationId);
        assertThat(vacation).isNotNull();
        assertThat(vacation.getVacationId()).isEqualTo(vacationId);
    }

    @Test
    void modifyVacationTest() {
        String vacationId = dataManagerVacation.getAllVacations().get(0).getVacationId();
        Vacation vacation = dataManagerVacation.getVacationById(vacationId);
        vacation.setStart(LocalDate.now().plusDays(1));
        vacation.setStop(LocalDate.now().plusDays(3));
        vacation.setVacationType(TypeOfVacation.ON_DEMAND);
        dataManagerVacation.modifyVacation(vacation);
        Vacation modifiedVacation = dataManagerVacation.getVacationById(vacationId);
        assertThat(modifiedVacation.getStart()).isEqualTo(vacation.getStart());
        assertThat(modifiedVacation.getStop()).isEqualTo(vacation.getStop());
        assertThat(modifiedVacation.getVacationType()).isEqualTo(vacation.getVacationType());
    }
}


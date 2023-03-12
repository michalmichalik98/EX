package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.TypeOfVacation;
import com.isa.vacationplanerwebapp.model.Vacation;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Controller
public class DataManagerVacation {

    private List<Vacation> allVacations;

    public DataManagerVacation() {
        createDummyData();
    }

    public List<Vacation> getAllVacations() {
        return allVacations;
    }

    public void createDummyData() {
        allVacations = new ArrayList<>();
        LocalDate today = LocalDate.now();

        allVacations.add( new Vacation(today , today.plusDays(10), TypeOfVacation.HOLIDAY, "7db420b8-f6d4-4380-b702-c4253a8c1a8d" ));
        allVacations.add( new Vacation(today , today.plusDays(5), TypeOfVacation.HOLIDAY, "d9bfe988-2a33-470c-b636-bc5ae8475d27" ));
        allVacations.add( new Vacation(today , today.plusDays(7), TypeOfVacation.HOLIDAY, "00b68768-c1d2-4a2a-9851-9deef5e37563" ));
        allVacations.add( new Vacation(today , today.plusDays(6), TypeOfVacation.HOLIDAY, "8f31aacf-9b2d-48e5-91d4-3016bf38d48e" ));
        allVacations.add( new Vacation(today , today.plusDays(11), TypeOfVacation.HOLIDAY, "3174f289-0db9-43d2-a69f-4de58cc02a72" ));
        allVacations.add( new Vacation(today , today.plusDays(12), TypeOfVacation.HOLIDAY, "1e073fa4-f403-4a8a-b913-498c1da826cb" ));
        allVacations.add( new Vacation(today , today.plusDays(16), TypeOfVacation.HOLIDAY, "56ca0eab-41e8-4d8c-a76d-853e44c436d9" ));
    }

    public void addVacation(Vacation vacation) {
        allVacations.add(vacation);
    }
}

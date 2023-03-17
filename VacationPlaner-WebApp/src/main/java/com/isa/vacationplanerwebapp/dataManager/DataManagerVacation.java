package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.exception.EmployeeNotFoundException;
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

    public void addVacation(Vacation vacation) {
        allVacations.add(vacation);
    }

    public void deleteVacation(String id) {
        allVacations.remove(getVacationById(id));

    }

    public Vacation getVacationById(String id) {
        return allVacations.stream().
                filter(vacation -> vacation.getVacationId().equals(id))
                .findAny().orElseThrow(() -> new EmployeeNotFoundException("Vacation not found with ID"));
    }

    public void modifyVacation(Vacation vacation) {

        allVacations.replaceAll(vacation1 -> {
            if (vacation1.getVacationId().equals(vacation.getVacationId())) {
                vacation1.setStart(vacation.getStart());
                vacation1.setStop(vacation.getStop());
                vacation1.setVacationType(vacation.getVacationType());
            }
            return vacation1;
        });
    }


    public void createDummyData() {
        allVacations = new ArrayList<>();
        LocalDate today = LocalDate.now();

        allVacations.add(new Vacation(today.minusDays(2), today.plusDays(10), TypeOfVacation.HOLIDAY, "f0ba16he-ceb1-4d0d-a8b9-0756682e4ae4", "Janusz", "Nowakowski"));
        allVacations.add(new Vacation(today.minusDays(3), today.plusDays(5), TypeOfVacation.ON_DEMAND, "r0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Janusz", "Wieczorek"));
        allVacations.add(new Vacation(today.minusDays(5), today.plusDays(7), TypeOfVacation.OTHER, "k0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Marek", "Krupa"));
        allVacations.add(new Vacation(today.minusDays(1), today.plusDays(6), TypeOfVacation.ON_DEMAND, "f0ba16ce-c1b1-4d0d-68b9-0756681e4ae4", "Krzysztof", "Nowak"));
        allVacations.add(new Vacation(today.minusDays(2), today.plusDays(5), TypeOfVacation.HOLIDAY, "f0ba16ce-ceb1-4d0d-a8b9-0756681e4a24", "Piotr", "Zieliński"));
        allVacations.add(new Vacation(today.minusDays(5), today.plusDays(1), TypeOfVacation.OTHER, "f0ba16ce-ceb1-4d3d-a8b9-0756681e4ae4", "Jan", "Kowalski"));
        allVacations.add(new Vacation(today.minusDays(8), today.plusDays(3), TypeOfVacation.HOLIDAY, "f0ba16ce-cebs-4ddd-a8b9-0756681e4ae4", "Ewa", "Mazur"));
        allVacations.add(new Vacation(today.minusDays(2), today.plusDays(7), TypeOfVacation.ON_DEMAND, "h0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Marta", "Jabłońska"));
        allVacations.add(new Vacation(today.minusDays(1), today.plusDays(6), TypeOfVacation.HOLIDAY, "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Tomasz", "Wojciechowski"));
        allVacations.add(new Vacation(today.minusDays(10), today.plusDays(20), TypeOfVacation.HOLIDAY, "f0ba16ce-ceb1-4d0d-a8b9-0756681e5ae4", "Alicja", "Wieczorek"));
        allVacations.add(new Vacation(today.minusDays(10), today.plusDays(20), TypeOfVacation.HOLIDAY, "fgba16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Krzysztof", "Jankowski"));
        allVacations.add(new Vacation(today.minusDays(10), today.plusDays(20), TypeOfVacation.HOLIDAY, "f0da16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Andrzej", "Kaczmarek"));
    }
}
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
                vacation1 = vacation;
            }
            return vacation1;
        });
    }


    public void createDummyData() {
        allVacations = new ArrayList<>();
        LocalDate today = LocalDate.now();

        allVacations.add(new Vacation(today.minusDays(2), today.plusDays(10), TypeOfVacation.HOLIDAY, "f0ba16ce-ceb1-4d0d-a8b9-0756681e4ae4", "Janusz", "Nowakowski"));
        allVacations.add(new Vacation(today.minusDays(3), today.plusDays(5), TypeOfVacation.ON_DEMAND, "1cef0f12-0360-4403-ab11-f620851c6611", "Alicja", "Wieczorek"));
        allVacations.add(new Vacation(today.minusDays(5), today.plusDays(7), TypeOfVacation.OTHER, "2122720c-57d1-49d3-aed2-56846f7244d3", "Marek", "Krupa"));
        allVacations.add(new Vacation(today.minusDays(1), today.plusDays(6), TypeOfVacation.ON_DEMAND, "2a58891a-0c4c-4f13-86a7-018aa9afe082", "Krzysztof", "Nowak"));
        allVacations.add(new Vacation(today.minusDays(2), today.plusDays(5), TypeOfVacation.HOLIDAY, "c926aa10-ac4d-49ff-8700-8598489a6d7b", "Piotr", "Zieliński"));
        allVacations.add(new Vacation(today.minusDays(5), today.plusDays(1), TypeOfVacation.OTHER, "e1825f46-b246-40fb-a91c-012ffc44d108", "Jan", "Kowalski"));
        allVacations.add(new Vacation(today.minusDays(8), today.plusDays(3), TypeOfVacation.HOLIDAY, "3c7a4498-b5c0-4c69-b1af-e7e9b7e6db69", "Ewa", "Mazur"));
        allVacations.add(new Vacation(today.minusDays(2), today.plusDays(7), TypeOfVacation.ON_DEMAND, "1d54bdd1-52a9-47fb-8fed-952b49b5d48e", "Marta", "Jabłońska"));
        allVacations.add(new Vacation(today.minusDays(1), today.plusDays(6), TypeOfVacation.HOLIDAY, "36dab8db-1fa5-4b33-a20a-ad314abaa8ba", "Tomasz", "Wojciechowski"));
    }
}
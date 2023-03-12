package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Vacation;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStart;
import org.springframework.stereotype.Controller;

import java.net.URISyntaxException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@Controller
public class VEventCreator {

    private final List<VEvent> allVacations;

    public VEventCreator() {
        this.allVacations = new ArrayList<>();
        createDummyData();
        createDummyData();
        createDummyData();
        createDummyData();
        createDummyData();
        createDummyData();
        createDummyData();
        createDummyData();
    }

    public List<VEvent> getAllVacations() {
        return allVacations;
    }

    public void creatVEvent(Vacation vacation, String id) {
        VEvent vacationEvent = new VEvent();

        String startDateString = (vacation.getStart() + "T000000Z").replace("-", "");
        String endDateString = (vacation.getStop() + "T235959Z").replace("-", "");

        try {
            DtStart dtStart = new DtStart(startDateString);
            DtEnd dtEnd = new DtEnd(endDateString);

            vacationEvent.getProperties().add(new Attendee(id));
            vacationEvent.getProperties().add(dtStart);
            vacationEvent.getProperties().add(dtEnd);
            allVacations.add(vacationEvent);

        } catch (URISyntaxException | ParseException e) {
            throw new RuntimeException(e);
        }
    }

    public void createDummyData(){
        VEvent vacationEvent = new VEvent();
        String startDateString = "20230301T000000Z";
        String endDateString = "2023035T235959Z";
        String id = "test";
        try {
            DtStart dtStart = new DtStart(startDateString);
            DtEnd dtEnd = new DtEnd(endDateString);

            vacationEvent.getProperties().add(new Attendee(id));
            vacationEvent.getProperties().add(dtStart);
            vacationEvent.getProperties().add(dtEnd);
            allVacations.add(vacationEvent);

        } catch (URISyntaxException | ParseException e) {
            throw new RuntimeException(e);
        }
    }
}

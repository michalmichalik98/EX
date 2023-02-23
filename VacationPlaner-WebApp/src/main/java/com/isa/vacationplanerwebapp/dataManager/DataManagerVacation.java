package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Vacation;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.DateTime;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.model.property.Attendee;
import net.fortuna.ical4j.model.property.DtEnd;
import net.fortuna.ical4j.model.property.DtStamp;
import net.fortuna.ical4j.model.property.DtStart;
import org.springframework.stereotype.Controller;

import java.net.URISyntaxException;
import java.text.ParseException;


@Controller
public class DataManagerVacation {


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

        } catch (URISyntaxException | ParseException e) {
            throw new RuntimeException(e);
        }


        System.out.println(vacationEvent.getProperties());

    }
}

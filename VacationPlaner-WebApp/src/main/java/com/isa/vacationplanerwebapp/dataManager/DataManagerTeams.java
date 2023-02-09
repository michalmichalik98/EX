package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataManagerTeams {

    private final List<Team> teams;

    public DataManagerTeams() {
        this.teams = importTeams();
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void addTeam(Team team) {
        teams.add(team);
    }

    public void deleteEmployee(Employee employee) {
        teams.remove(employee);
    }


    private List<Team> importTeams() {
        List<Team> team = new ArrayList<>();
        team.add(new Team("Niebiescy"));
        team.add(new Team("Czerwoni"));
        team.add(new Team("Zieloni"));
        team.add(new Team("Żółci"));

        return team;
    }
}

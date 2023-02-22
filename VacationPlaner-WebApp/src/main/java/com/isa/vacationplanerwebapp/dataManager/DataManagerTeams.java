package com.isa.vacationplanerwebapp.dataManager;

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

    public boolean addTeam(Team team) {
        if (teams.contains(team)) {
            return false;
        }
        return teams.add(team);
    }

    public void deleteTeam(Team team) {
        teams.remove(team);
    }

    public boolean teamWithNameExists(String team){
        return teams.stream().anyMatch(obj ->obj.getTeamName().equals(team));
    }
    //ToD
    // Modyfikacja teamu, przekazqanie Team


    private List<Team> importTeams() {
        List<Team> team = new ArrayList<>();
        team.add(new Team("Niebiescy"));
        team.add(new Team("Czerwoni"));
        team.add(new Team("Zieloni"));
        team.add(new Team("Żółci"));

        return team;
    }
}

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

    public void deleteTeam(String teamName) {
        teams.remove(getTeamByName(teamName));
    }

    public Team getTeamByName(String teamName) {
        for (Team team : teams) {
            if (team.getTeamName().equals(teamName)) {
                return team;
            }
        }
        return null;
    }


    public void renameTeam(String oldTeamName, String newTeamName) {
        teams.replaceAll(team1 -> {
            if (team1.getTeamName().equals(oldTeamName)) {
                team1.setTeamName(newTeamName);
            }
            return team1;
        });
    }
//
    // / public void modifyTeam(String teamName, Team team) {
    //  Team teamToModify = getTeamByName(teamName);
    //  teamToModify.setTeamName(team.getTeamName());


    //teams.replaceAll(team1 -> {
    //     if (team1.getTeamName().equals(team.getTeamName())) {
    //          team1.setTeamName(team.getTeamName());
    //     }
    //     return team1;
    //  });
    // }

    private List<Team> importTeams() {

        List<Team> teams = new ArrayList<>();

        teams.add(new Team("Niebiescy"));
        teams.add(new Team("Czerwoni"));
        teams.add(new Team("Zieloni"));
        teams.add(new Team("Żółci"));
        teams.add(new Team("Czarni"));

        return teams;
    }
}

package com.isa.vacationplanerwebapp.dataManager;
import com.isa.vacationplanerwebapp.exception.TeamNotFoundException;
import com.isa.vacationplanerwebapp.model.Team;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    public void deleteTeam(String teamName) {
        teams.remove(getTeamByName(teamName));
    }

/*
    public Team getTeamByName(String teamName) {
        return teams.stream().filter(team -> team.getTeamName().equals(teamName))
                .findFirst().orElseThrow(() -> new TeamNotFoundException("Team not found with name"));
    }*/
    public List<Team> getTeamByName(String teamName) {
        return teams.stream()
                .filter(team -> team.getTeamName().equals(teamName))
                .collect(Collectors.toList());
    }

    public void modifyTeam(String teamName, Team team) {
      //  Team teamToModify = getTeamByName(teamName);
      //  teamToModify.setTeamName(team.getTeamName());

       teams.replaceAll(team1 -> {
            if (team1.getTeamName().equals(team.getTeamName())) {
                team1.setTeamName(team.getTeamName());
            }
            return team1;
        });
    }

   // private boolean isTeamNameExists(String teamName) {
     //   return teams.stream().anyMatch(team -> team.getTeamName().equals(teamName));
    //}
    private List<Team> importTeams() {

        List<Team> teams = new ArrayList<>();

        teams.add(new Team("Niebiescy"));
        teams.add(new Team("Czerwoni"));
        teams.add(new Team("Zieloni"));
        teams.add(new Team("Żółci"));
        teams.add(new Team("Czarni"));
        teams.add(new Team("Brązowi"));
        teams.add(new Team("Biali"));
        teams.add(new Team("Błękitni"));
        teams.add(new Team("Pomarańczowi"));
        teams.add(new Team("Różowi"));
        teams.add(new Team("Szarzy"));
        teams.add(new Team("Złoci"));

        return teams;
    }
}

package com.isa.vacationplanerwebapp.dataManager;


import com.isa.vacationplanerwebapp.model.Team;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class DataManagerTeamsTest {

    private DataManagerTeams dataManagerTeams;

    @BeforeEach
    void before() {
        dataManagerTeams = new DataManagerTeams();
    }

    @Test
    void getTeamsTest() {
        List<Team> teams = dataManagerTeams.getTeams();

        assertThat(teams).hasSize(5);
    }

    @Test
    void addTeamTest() {
        Team team = new Team("Test team");

        boolean added = dataManagerTeams.addTeam(team);

        assertThat(added).isTrue();
        assertThat(dataManagerTeams.getTeams()).contains(team);
    }

    @Test
    void addTeamDoesNotAddExistingTeamTest() {

        Team team = new Team("Niebiescy");

        boolean added = dataManagerTeams.addTeam(team);

        assertThat(added).isFalse();
    }

    @Test
    void deleteTeamTest() {

        String teamName = "Niebiescy";

        dataManagerTeams.deleteTeam(teamName);

        assertThat(dataManagerTeams.getTeams()).noneMatch(team -> team.getTeamName().equals(teamName));
    }

    @Test
    void getTeamByNameReturnsCorrectTeamTest() {
        String teamName = "Niebiescy";

        Team team = dataManagerTeams.getTeamByName(teamName);

        assertThat(team).isNotNull();
        assertThat(team.getTeamName()).isEqualTo(teamName);
    }

    @Test
    void getTeamByNameReturnsNullIfTeamNotFoundTest() {
        String teamName = "idkwhatever";

        Team team = dataManagerTeams.getTeamByName(teamName);

        assertThat(team).isNull();
    }

    @Test
    void renameTeamTest() {
        String oldTeamName = "Niebiescy";
        String newTeamName = "Nowi niebiescy";

        dataManagerTeams.renameTeam(oldTeamName, newTeamName);

        assertThat(dataManagerTeams.getTeams()).extracting(Team::getTeamName).contains(newTeamName);
        assertThat(dataManagerTeams.getTeams()).noneMatch(team -> team.getTeamName().equals(oldTeamName));
    }
}


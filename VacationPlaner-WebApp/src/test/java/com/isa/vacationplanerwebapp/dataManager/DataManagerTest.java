package com.isa.vacationplanerwebapp.dataManager;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.vacationplanerwebapp.model.Address;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Team;


import com.isa.vacationplanerwebapp.model.Vacation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Properties;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataManagerTest {
    private Address address = new Address("Wiosenna", "233", "Radom", "02-777");
    private DataManager dataManager;
    private Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com", address, "111222333");
    private static final Path pathForTeamDataFile = Paths.get("src", "main", "resources", "dataFiles", "Team.json");

    @BeforeEach
    void before(){
         dataManager = new DataManager();
    }
    @AfterEach
    void afterTest() throws IOException {
        Files.deleteIfExists(Path.of("config.properties"));
        DataManager.employeeList.clear();
        DataManager.teamList.clear();
        DataManager.vacationList.clear();
    }
    @Test
    void setpropertyTest() throws IOException {
        DataManager dataManager = new DataManager();
        dataManager.setproperty();

        Properties properties = new Properties();
        FileInputStream inputStream = new FileInputStream("config.properties");
        properties.load(inputStream);

        assertThat(properties.getProperty("filePath")).isEqualTo("src/main/resources/dataFiles/Employee.json");
    }

    @Test
    void addEmployeeTest() {
        DataManager.employeeList.clear();
        boolean result = DataManager.addEmployee(employee);
        assertTrue(result);
        Assertions.assertEquals(1, DataManager.employeeList.size());

        Employee employee2 = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com", address, "111222333");
        result = DataManager.addEmployee(employee2);
        assertFalse(result);
        Assertions.assertEquals(1, DataManager.employeeList.size());
        DataManager.employeeList.remove(employee);
    }


    @Test
    void saveAndLoadEmployeeFromFileTest() throws IOException {
        DataManager.employeeList.clear();
        DataManager.addEmployee(employee);
        DataManager.saveEmployeesToFIle();

        DataManager.employeeList.clear();

        DataManager.loadEmployeeFromFile();

        Assertions.assertEquals(1, DataManager.employeeList.size());
        Assertions.assertEquals("Jan", DataManager.employeeList.get(0).getName());
        Assertions.assertEquals("Kowalski", DataManager.employeeList.get(0).getSurname());
        Assertions.assertEquals("12345678901", DataManager.employeeList.get(0).getPesel());
        Assertions.assertEquals("jan.kowalski@gmail.com", DataManager.employeeList.get(0).getEmail());
        Assertions.assertEquals(address, DataManager.employeeList.get(0).getAddress());
        Assertions.assertEquals("111222333", DataManager.employeeList.get(0).getPhoneNumber());
    }

    @Test
    void addTeamTest() {
        Team team = new Team("ezwin");
        boolean result = DataManager.addTeam(team);
        assertTrue(result);

        Team team2 = new Team("ezwin");
        result = DataManager.addTeam(team2);
        assertFalse(result);
    }

    @Test
    void testSaveTeamToFile() throws IOException {
        ArrayList<Team> testTeamList = new ArrayList<>();
        testTeamList.add(new Team("bruh"));
        DataManager.teamList = testTeamList;
        DataManager.saveTeamToFile();

        ObjectMapper objectMapper = new ObjectMapper();
        String teamJson = Files.readString(pathForTeamDataFile);
        ArrayList<Team> savedTeamList = objectMapper.readValue(teamJson, new TypeReference<>() {});

        assertThat(savedTeamList).isEqualTo(testTeamList);
    }

    @Test
    void loadTeamFromFileTest() throws IOException {
        ArrayList<Team> testTeamList = new ArrayList<>();
        testTeamList.add(new Team("kms"));
        ObjectMapper objectMapper = new ObjectMapper();
        Files.writeString(pathForTeamDataFile, objectMapper.writeValueAsString(testTeamList));

        DataManager.loadTeamFromFile();

        assertThat(DataManager.teamList).isEqualTo(testTeamList);
    }


    @Test
    void addVacationTest() {
        Vacation vacation = new Vacation();
        boolean result = DataManager.addVacation(vacation);

        assertThat(result).isTrue();
        assertThat(DataManager.vacationList).contains(vacation);

        boolean duplicateResult = DataManager.addVacation(vacation);
        assertThat(duplicateResult).isFalse();
        assertThat(DataManager.vacationList).containsOnlyOnce(vacation);
    }
}


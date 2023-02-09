package com.isa.vacationplanerwebapp.dataManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Team;
import com.isa.vacationplanerwebapp.model.Vacation;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

@Service
public class DataManager {


    public static ArrayList<Employee> employeeList = new ArrayList<>();
    public static ArrayList<Team> teamList = new ArrayList<>();
    public static ArrayList<Vacation> vacationList = new ArrayList<>();



    private static final Path pathForEmployeeDataFile = Paths.get("src", "main", "resources","dataFiles", "Employee.json");
    private static final Path pathForTeamDataFile = Paths.get("src", "main", "resources","dataFiles", "Team.json");
    private static final Path pathForVacationDataFile = Paths.get("src", "main", "resources","dataFiles", "Vacation.json");
    private static final Path pathForIdNumberDataFile = Paths.get("src", "main", "resources","dataFiles", "ID.txt");

    public DataManager() {
    }
    public void setproperty(){
        Properties properties = new Properties();
        properties.setProperty("filePath","src/main/resources/dataFiles/Employee.json");

        try {
            properties.store(new FileOutputStream("config.properties"), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static void saveAllDataToFile() {
        saveEmployeesToFIle();
        saveTeamToFile();
        saveVacationToFile();
    }

    public static boolean addEmployee(Employee employee) {

        if (employeeList.contains(employee)) {
            System.out.println("Pracownik już istnieje");
            return false;
        } else {
            employeeList.add(employee);
            return true;
        }
    }

    public static void saveEmployeesToFIle() {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String employeeJson = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(employeeList);

            Files.write(pathForEmployeeDataFile, employeeJson.getBytes());

        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadEmployeeFromFile() {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String employeeObjectAsStrings = Files.readString(pathForEmployeeDataFile);
            employeeList = objectMapper.readValue(employeeObjectAsStrings, new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
           e.printStackTrace();
        }

    }

    public static List<Employee> getEmployeeList() {
        loadEmployeeFromFile();
        return employeeList;
    }

    public static void deleteAllEmployeeDataFromFile() {
        try {
            Files.deleteIfExists(pathForEmployeeDataFile);
            Files.createFile(pathForEmployeeDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addTeam(Team team) {
        if (teamList.contains(team)) {
            System.out.println("Taka drużyna już istnieje");
            return false;
        } else {
            teamList.add(team);
            return true;
        }
    }

    public static void saveTeamToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String teamJson = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(teamList);

            Files.write(pathForTeamDataFile, teamJson.getBytes());

        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadTeamFromFile() {

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String employeeObjectAsStrings = Files.readString(pathForTeamDataFile);
            teamList = objectMapper.readValue(employeeObjectAsStrings, new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Brak danych do załadowania");
        }

    }

    public static List<Team> getTeamList() {
        loadTeamFromFile();
        return teamList;
    }

    public static void deleteAllTeamsFromFile() {
        try {
            Files.deleteIfExists(pathForTeamDataFile);
            Files.createFile(pathForTeamDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean addVacation(Vacation vacation) {
        if (vacationList.contains(vacation)) {
            System.out.println("Taka drużyna już istnieje");
            return false;
        } else {
            vacationList.add(vacation);
            return true;
        }
    }

    public static void saveVacationToFile() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String teamJson = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(vacationList);

            Files.write(pathForVacationDataFile, teamJson.getBytes());

        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadVacationFromFile() {

        ObjectMapper objectMapperForVacation = new ObjectMapper();

        try {
            String employeeObjectAsStrings = Files.readString(pathForVacationDataFile);
            vacationList = objectMapperForVacation.readValue(employeeObjectAsStrings, new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Brak danych do załadowania");
        }

    }

    public static List<Vacation> getVacationList() {
        loadVacationFromFile();
        return vacationList;
    }

    public static void deleteAllVacationFromFile() {
        try {
            Files.deleteIfExists(pathForVacationDataFile);
            Files.createFile(pathForVacationDataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Integer employeeIdGenerator() {

        Integer lastUsedI = 0;

        if(!Files.exists(pathForIdNumberDataFile)){
            try {
                Files.createFile(pathForIdNumberDataFile);
                Files.write(pathForIdNumberDataFile,"0".getBytes());
            }catch (Exception e){
                System.out.println("Nie mogłem stworzyc pliku");
            }
        };
        try {
            lastUsedI = Integer.parseInt(Files.readString(pathForIdNumberDataFile));
            lastUsedI++;
            Files.write(pathForIdNumberDataFile, lastUsedI.toString().getBytes());
            return lastUsedI;
        } catch (IOException e) {
            System.out.println(".");
        }
        return 0;
    }
}

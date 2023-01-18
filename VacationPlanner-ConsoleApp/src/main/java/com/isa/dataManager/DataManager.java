package com.isa.dataManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.model.Employee;
import com.isa.model.Team;
import com.isa.model.Vacation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

  public static ArrayList<Employee> employeeList = new ArrayList<>();
  public static ArrayList<Team> teamList = new ArrayList<>();
  public static ArrayList<Vacation> vacationList = new ArrayList<>();

    private static final Path pathForEmployeeDataFile = Paths.get( "src", "main", "resources", "Employee.json");
    private static final Path pathForTeamDataFile = Paths.get("src", "main", "resources", "Team.json");
    private static final Path pathForVacationDataFile = Paths.get("src", "main", "resources", "Vacation.json");

    public static void loadAllDataFromFile(){
        loadEmployeeFromFile();
        loadVacationFromFile();
        loadTeamFromFile();
    }

    public static boolean addEmployee(Employee employee) {

        if (employeeList.contains(employee)) {
            System.out.println("Pracownik już istnieje");
            return false;
        } else {
            employeeList.add(employee);
            saveEmployees();
            return true;
        }
    }
    public static void saveEmployees() {
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
            System.out.println("Brak danych do załadowania");
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
        }catch (IOException e){
            e.printStackTrace();
        }
    }


    public static boolean addTeam(Team team){
        if(teamList.contains(team)){
            System.out.println("Taka drużyna już istnieje");
            return false;
            }else{
            teamList.add(team);
            saveTeam();
            return true;
        }
    }
    public static void saveTeam() {
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
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static boolean addVacation(Vacation vacation){
        if(vacationList.contains(vacation)){
            System.out.println("Taka drużyna już istnieje");
            return false;
        }else{
            vacationList.add(vacation);
            saveVacation();
            return true;
        }
    }
    public static void saveVacation() {
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

        ObjectMapper objectMapper = new ObjectMapper();

        try {
            String employeeObjectAsStrings = Files.readString(pathForVacationDataFile);
            vacationList = objectMapper.readValue(employeeObjectAsStrings, new TypeReference<>() {
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
    public static void deleteAllVacationFromFile(){
        try {
            Files.deleteIfExists(pathForVacationDataFile);
            Files.createFile(pathForVacationDataFile);
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}

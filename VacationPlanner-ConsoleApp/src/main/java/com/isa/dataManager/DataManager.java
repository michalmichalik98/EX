package com.isa.dataManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.ReferenceType;
import com.isa.model.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public static ArrayList<Employee> employeeList = new ArrayList<>();

    public static List<Employee> getEmployeeList() {
        loadEmployeeFromFile();
        return employeeList;
    }

    public static boolean addEmployee(Employee employee) {

        if (employeeList.contains(employee)) {
            System.out.println("Pracownik już istnieje");
            return false;
        } else {
            employeeList.add(employee);
            saveEmployees();
            System.out.println("eureka");
            return true;
        }
    }

    public static void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public static void saveEmployees() {
        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("VacationPlanner-ConsoleApp", "src", "main", "resources", "Employee.json");

        try {
            String employeeJson = objectMapper
                    .writerWithDefaultPrettyPrinter()
                    .writeValueAsString(employeeList);

            Files.write(path, employeeJson.getBytes());

        } catch (JsonParseException | JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void loadEmployeeFromFile() {

        ObjectMapper objectMapper = new ObjectMapper();
        Path path = Paths.get("VacationPlanner-ConsoleApp", "src", "main", "resources", "Employee.json");

        try {
            String employeeObjectAsStrings = Files.readString(path);
            employeeList = objectMapper.readValue(employeeObjectAsStrings, new TypeReference<>() {
            });
        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Brak danych do załadowania");
        }

    }


}

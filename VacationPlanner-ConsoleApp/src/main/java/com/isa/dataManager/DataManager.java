package com.isa.dataManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.model.Employee;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;

public class DataManager {

    public ArrayList<Employee> employeeList = new ArrayList<>();


    public void addEmployee(Employee employee) {
        employeeList = loadEmployeeList();
        if (employeeList.contains(employee)) {
            System.out.println("Pracownik już istnieje");
        } else {
            employeeList.add(employee);
            saveEmployees(employeeList);

        }
    }

    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void saveEmployees(ArrayList<Employee> employees) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File("src/main/java/com/isa/dataManager/Employees.txt"), employeeList);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public ArrayList<Employee> loadEmployeeList() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return employeeList = objectMapper.readValue(Paths.get("src/main/java/com/isa/dataManager/Employees.txt").toFile(), ArrayList.class);

        } catch (JsonParseException e) {
            e.printStackTrace();
        } catch (StreamReadException e) {
            throw new RuntimeException(e);
        } catch (DatabindException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}

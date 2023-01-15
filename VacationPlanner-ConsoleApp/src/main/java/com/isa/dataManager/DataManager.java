package com.isa.dataManager;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.isa.model.Employee;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DataManager {

    public ArrayList<Employee> employeeList = new ArrayList<>();


    public void addEmployee(Employee employee) {
        if (employeeList.contains(employee)) {
            System.out.println("Pracownik już istnieje");
        } else {
            employeeList.add(employee);
            saveEmployees();

        }
    }

    public void deleteEmployee(Employee employee) {
        employeeList.remove(employee);
    }

    public void saveEmployees() {
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


    public List<Employee> loadEmployeeList() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return employeeList = objectMapper.readValue(Paths.get("src/main/java/com/isa/dataManager/Employees.txt").toFile(), new TypeReference<ArrayList<Employee>>() {

            });

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

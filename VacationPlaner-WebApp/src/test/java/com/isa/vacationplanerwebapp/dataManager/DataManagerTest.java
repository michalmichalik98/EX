package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Address;
import com.isa.vacationplanerwebapp.model.Employee;
import com.isa.vacationplanerwebapp.model.Team;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DataManagerTest {
    private Address address = new Address("Wiosenna","233","Radom","02-777");
    private DataManager dataManager = new DataManager();
    @BeforeAll
    public static void setUp() {
        DataManager.employeeList.clear();
        DataManager.teamList.clear();
        DataManager.vacationList.clear();
    }

    @Test
    public void addEmployeeTest() {
        DataManager.employeeList.clear();
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333");

        boolean result = DataManager.addEmployee(employee);
        assertTrue(result);
        Assertions.assertEquals(1, DataManager.employeeList.size());

        Employee employee2 = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333");
        boolean result2 = DataManager.addEmployee(employee2);
        assertFalse(result2);
        Assertions.assertEquals(1, DataManager.employeeList.size());
    }


    @Test
    public void saveAndLoadEmployeeFromFileTest() throws IOException {
        DataManager.employeeList.clear();
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333");
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
    public void addTeamTest(){
        Team team = new Team("ezwin");
        boolean result = DataManager.addTeam(team);
        assertTrue(result);

        Team team2 = new Team("ezwin");
        result = DataManager.addTeam(team2);
        assertFalse(result);
    }



}


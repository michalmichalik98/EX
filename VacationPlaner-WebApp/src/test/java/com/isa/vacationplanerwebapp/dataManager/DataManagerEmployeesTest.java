package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.exception.EmployeeNotFoundException;
import com.isa.vacationplanerwebapp.model.Address;
import com.isa.vacationplanerwebapp.model.Employee;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class DataManagerEmployeesTest {
    private Address address = new Address("Polna", "44", "Łódź","03-222");
    private DataManagerEmployees dataManagerEmployees = new DataManagerEmployees();

    @Test
    void addEmployeeShouldAddNewEmployeeToUnAssignedTeamTest() {
        Employee newEmployee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333");
        dataManagerEmployees.addEmployee(newEmployee);

        assertThat(dataManagerEmployees.getEmployees()).contains(newEmployee);
        assertThat(newEmployee.getTeam()).isEqualTo(Employee.UNASSIGNED_TEAM);
    }

    @Test
    void deleteEmployeeShouldRemoveEmployeeFromListTest() {
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333");
        dataManagerEmployees.addEmployee(employee);
        String idToRemove = employee.getEmployeeId();
        dataManagerEmployees.deleteEmployee(idToRemove);
        assertThat(dataManagerEmployees.getEmployees()).doesNotContain(employee);
    }
    @Test
    void getEmployeeByIdShouldReturnCorrectEmployeeTest() {
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333", "Czarni");
        dataManagerEmployees.addEmployee(employee);

        String idToGet = employee.getEmployeeId();
        Employee result = dataManagerEmployees.getEmployeeById(idToGet);

        assertThat(result).isEqualTo(employee);
    }

    @Test
    void getEmployeeByIdShouldThrowExceptionIfEmployeeNotFoundTest() {
        String invalidId = "invalid-id";
        assertThatExceptionOfType(EmployeeNotFoundException.class)
                .isThrownBy(() -> dataManagerEmployees.getEmployeeById(invalidId))
                .withMessage("Employee not found with ID");
    }
    @Test
    void modifyEmployeeShouldUpdateEmployeeDetailsTest() {
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333", "Czarni");
        dataManagerEmployees.addEmployee(employee);
        Employee updatedEmployee = new Employee("Zenek", "Kowalski", "12366678901", "jan.kowalski@gmail.com",address, "111222333", "Czarni");
        dataManagerEmployees.addEmployee(updatedEmployee);
        updatedEmployee.setEmployeeId(employee.getEmployeeId());

        dataManagerEmployees.modifyEmployee(updatedEmployee);

        Employee result = dataManagerEmployees.getEmployeeById(employee.getEmployeeId());
        assertThat(result).isEqualTo(updatedEmployee);
    }

    @Test
    void setTeamToUnassignedTest() {
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333", "Czarni");
        dataManagerEmployees.addEmployee(employee);
        dataManagerEmployees.setTeamToUnassigned(employee.getEmployeeId());
        assertThat(dataManagerEmployees.getEmployeeById(employee.getEmployeeId()).getTeam()).isEqualTo(Employee.UNASSIGNED_TEAM);
    }

    @Test
    void changeTeamNameTest() {
        Employee employee = new Employee("Jan", "Kowalski", "12345678901", "jan.kowalski@gmail.com",address, "111222333", "Czarni1");
        dataManagerEmployees.addEmployee(employee);
        dataManagerEmployees.changeTeamName("Czarni1", "Biali1");
        assertThat(dataManagerEmployees.getEmployeesByTeam("Czarni1")).isEmpty();
        assertThat(dataManagerEmployees.getEmployeesByTeam("Biali1")).hasSize(1);
    }

}

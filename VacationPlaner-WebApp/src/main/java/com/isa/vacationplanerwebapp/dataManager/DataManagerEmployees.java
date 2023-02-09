package com.isa.vacationplanerwebapp.dataManager;

import com.isa.vacationplanerwebapp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DataManagerEmployees {

    private final List<Employee> employees;

    public DataManagerEmployees() {
        this.employees = importEmployees();
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    public Employee findEmployee(String pesel) {
        return employees.stream().filter(employee -> employee.getPesel().equals(pesel)).findFirst().orElse(null);
    }

    private List<Employee> importEmployees() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("Marcin", "Adamski", "872345601", "adamskim@gmail.com", "Parkowa 3/2", "608753496"));
        employees.add(new Employee("Anna", "Nowak", "872613485", "anna.nowak@gmail.com", "Kwiatowa 5/2", "603984672"));
        employees.add(new Employee("Jan", "Kowalski", "871425363", "jkowalski@o2.pl", "Parkowa 1/3", "604236589"));
        employees.add(new Employee("Agnieszka", "Wiśniewska", "873654287", "wiśniewska@wp.pl", "Lasowa 8/4", "604987563"));
        employees.add(new Employee("Tomasz", "Mazur", "877532648", "mazur.t@gmail.com", "Zielona 9/1", "605987236"));
        employees.add(new Employee("Marta", "Wójcik", "871523645", "martawojcik@o2.pl", "Polna 2/6", "608753421"));
        employees.add(new Employee("Katarzyna", "Jankowska", "874567312", "jankowska.k@gmail.com", "Słoneczna 7/3", "609765432"));
        employees.add(new Employee("Piotr", "Król", "875896321", "piotrkrol@wp.pl", "Zaciszna 4/5", "604372569"));
        employees.add(new Employee("Monika", "Woźniak", "876543298", "wozniakm@o2.pl", "Lipowa 6/1", "609874563"));

        return employees;
    }
}

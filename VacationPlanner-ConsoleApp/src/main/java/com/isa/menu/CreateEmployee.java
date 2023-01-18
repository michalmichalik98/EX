package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;

import java.util.Scanner;

public class CreateEmployee {

    public void consoleEmployeeData() {
        while (true) {
            Employee employee = new Employee();

            employee.setName(dataInput("Podaj imię pracownika"));
            employee.setSurname(dataInput("Podaj nazwisko pracownika"));
            employee.setAddress(dataInput("Podaj adres pracownika"));
            employee.setPesel(dataInput("Podaj PESEL pracownika"));
            employee.setEmail(dataInput("Podaj Email Pracownika"));
            employee.setPhoneNumber(dataInput("Podaj numer telefonu pracownika"));

            DataManager dataManager = new DataManager();
            dataManager.addEmployee(employee);

            System.out.println("Dodać kolejnego pracownika? (y/n)");

            String response = dataInput("Dodać kolejnego pracownika? (y/n)");

            if (response.equals("n")) {
                break;
            }
        }
    }
    public String dataInput(String question) {
        Scanner scanner = new Scanner(System.in);
        String input;
        System.out.println(question);
        input = scanner.nextLine();
        return input;
    }
}

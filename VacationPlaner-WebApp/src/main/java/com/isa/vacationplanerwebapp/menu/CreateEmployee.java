package com.isa.vacationplanerwebapp.menu;


import com.isa.vacationplanerwebapp.dataManager.DataManager;
import com.isa.vacationplanerwebapp.model.Employee;

import java.util.Scanner;

public class CreateEmployee {

    public void consoleEmployeeData() {
        while (true) {
            Employee employee = new Employee();

            employee.setName(dataInput("Podaj imię pracownika"));
            employee.setSurname(dataInput("Podaj nazwisko pracownika"));
            employee.setPesel(dataInput("Podaj PESEL pracownika"));
            employee.setEmail(dataInput("Podaj Email Pracownika"));
            employee.setPhoneNumber(dataInput("Podaj numer telefonu pracownika"));
           DataManager.addEmployee(employee);

            String response=  dataInput("Dodać kolejnego pracownika? (y/n)");
            System.out.println(response);
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

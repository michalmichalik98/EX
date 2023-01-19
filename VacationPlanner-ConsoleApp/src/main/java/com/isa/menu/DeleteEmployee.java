package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;

import java.util.Scanner;

public class DeleteEmployee {
    public void delete() {
        System.out.println("Podaj PESEL pracownika do usunięcia: ");

        String pesel = userInput();
        for (Employee employee : DataManager.employeeList) {

            if(employee.getPesel().equals(pesel)) {
                DataManager.employeeList.remove(employee);
                System.out.println("Pracownik" + employee.getName() + employee.getSurname() + "został usunięty/a");
                break;
            }
        }
        System.out.println("Nie ma pracownika o takim numerze PESEL");
    }

    public String userInput() {
        Scanner scanner = new Scanner(System.in);
        String input;
        input = scanner.nextLine();
        return input;
    }
}

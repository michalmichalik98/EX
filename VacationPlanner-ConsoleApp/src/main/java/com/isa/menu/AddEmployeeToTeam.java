package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;
import com.isa.model.Team;

import java.util.Scanner;

public class AddEmployeeToTeam {

    public void add() {
        int exit = 1;
        while (exit != 0) {

            System.out.println("Pracownicy bez zespołu:");
            printUnassignedEmployees();
            System.out.print("Podaj numer pracownika: ");
            int employeeSelected = selectEmployee();

            System.out.println("\nDostępne zespoły");
            printAllTeams();
            System.out.print("Wybież numer zestołu do którego przypisać pracownika: ");
            int teamSelected = userInput() ;

            DataManager.employeeList.get(employeeSelected)
                    .setTeam(DataManager.teamList.get(teamSelected).getTeamName());

            System.out.println("Pracownik " +
                    DataManager.employeeList.get(employeeSelected).getName() + " " +
                    DataManager.employeeList.get(employeeSelected).getSurname() + " został dodany do zespołu " +
                    DataManager.employeeList.get(employeeSelected).getTeam());
            exit = employeeSelected;
        }
    }

    private int selectEmployee() {
        int employeeSelected = userInput()-1 ;
        System.out.println("Wybrałeś: "
                + DataManager.employeeList.get(employeeSelected).getName() + " "
                + DataManager.employeeList.get(employeeSelected).getSurname());
        return employeeSelected;
    }

    private void printUnassignedEmployees() {

        int i = 1;

        for (Employee employee : DataManager.employeeList) {
            if (employee.getTeam().equals("UnAssignedTeam")) {
                System.out.println(i++ + ". " + employee.getName() + " " + employee.getSurname());
            }
        }
        System.out.println("0. Wyjście");

    }

    public int userInput() {
        Scanner scanner = new Scanner(System.in);
        int input;
        input = scanner.nextInt();
        return input;
    }

    private void printAllTeams() {
        int i = 1;
        for (Team teamName : DataManager.teamList) {
            System.out.println(i++ + ". " + teamName);
        }
        System.out.println("0. " + "Wyjście");
    }
}


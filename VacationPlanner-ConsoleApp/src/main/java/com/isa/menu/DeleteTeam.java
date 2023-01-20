package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;
import com.isa.model.Team;

import java.util.Scanner;

public class DeleteTeam {
    public void deleteTeam() {
        int exit = 1;
        DataManager.loadTeamFromFile();
        while (exit != 0) {
            System.out.println("Podaj numer zespoł który chcesz usunąć:");
            printAllTeams();
            int selection = userInput();
            cleanTeamFromEmployee(DataManager.teamList.get(selection).getTeamName());
            DataManager.teamList.remove(selection);
            exit = 0;
        }
    }

    public int userInput() {
        Scanner scanner = new Scanner(System.in);
        int input;
        input = scanner.nextInt();
        return input - 1;
    }

    private void cleanTeamFromEmployee(String teamName) {
        for (Employee employee : DataManager.employeeList) {
            if (employee.getTeam().equals(teamName)) {
                employee.setTeam("UnAssignedTeam");
            }
        }
    }

    private void printAllTeams() {
        int i = 1;
        for (Team teamName : DataManager.teamList) {
            System.out.println(i++ + ". " + teamName);
        }
        System.out.println("0. " + "Wyjście\n\n");
    }
}


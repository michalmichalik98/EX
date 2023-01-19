package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Team;

import java.util.Scanner;

public class DeleteTeam {
    public void deleteTeam() {
        int exit =1;
        DataManager.loadTeamFromFile();
        while(exit !=0) {
            System.out.println("Podaj numer zespół który chcesz usunąć:");
            printAllTeams();
            exit = userInput();
            DataManager.teamList.remove(exit -1);
        }
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
        System.out.println( "0. " + "Wyjście\n\n");
    }
}


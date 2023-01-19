package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;
import com.isa.model.Team;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DeleteEmployeeFromTeam {

    Map<Integer,Integer> employeeMap = new HashMap<>();

    public void delete() {
        System.out.println("Z któreho zespołu usunąć pracownika?");
        printAllTeams();
        int teamSelection = userSelectionForTeam();
        String selectedTeam = DataManager.teamList.get(teamSelection).getTeamName();
        printEmployeeFromTeam(selectedTeam);

        System.out.println("Podaj numer pracownika do usunięcia:");

        setEmployeeMap(selectedTeam);
        int selection = employeeMap.get(userSelectionForEmployee()) ;

        DataManager.employeeList.get(selection).setTeam("UnAssignedTeam");
        printEmployeeFromTeam(DataManager.teamList.get(teamSelection).getTeamName());
    }
    private void printAllTeams() {
        int i = 1;
        for (Team team : DataManager.teamList) {
            System.out.println(i++ + ". " + team.getTeamName());
        }
    }

    private void printEmployeeFromTeam(String teamName) {
        int i = 1;
        System.out.println("Pracownicy w zespole");
        for (Employee employee : DataManager.employeeList) {
            if (employee.getTeam().equals(teamName))
                System.out.println(i++ + ". " + employee.getName()
                        + " " + employee.getSurname());
        }
    }

    private int userSelectionForTeam(){
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        return selection -1;
    }
    private int userSelectionForEmployee(){
        Scanner scanner = new Scanner(System.in);
        int selection = scanner.nextInt();
        return selection ;
    }
    private void setEmployeeMap(String teamName ){
        Integer i = 1;
        for (Employee employee : DataManager.employeeList) {
            if(employee.getTeam().equals(teamName))
                employeeMap.put(i++,DataManager.employeeList.indexOf(employee));
        }
    }
}


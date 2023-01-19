package com.isa.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBehaviour {

    public static MenuList getMenuItem(int number) {

        MenuList chooseToReturn = null;
        for (MenuList menuList : MenuList.values()) {
            if (menuList.getPosition() == number) {
                chooseToReturn = menuList;
            }
        }
        return chooseToReturn;
    }

    public void printMenu() {
        for (MenuList menuList : MenuList.values()) {
            System.out.println(menuList);
        }
    }

    public void retrieveSelection() {

        int value = 0;
        while (value != 11) {
            printMenu();
            System.out.println("\nWybierz opcję za pomocą numeru: \n");
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
                selectionAction(value);
                if (getMenuItem(value) == null) {
                    throw new RuntimeException("Proszę podaj numer z zakresu przedstawionego w menu.");
                } else System.out.println("\n");
            } catch (InputMismatchException ex) {
                System.out.println("Podaj cyfrę.\n");
            } catch (RuntimeException ex) {
                System.out.println("Proszę podaj numer z zakresu przedstawionego w menu.");
            } catch (Exception e) {
                System.out.println("Niespotykany błąd.\n");
            }
        }
    }

    public void selectionAction(int value) {

        switch (value) {
            case 1:
                CreateVacationDay createVacationDay = new CreateVacationDay();
                createVacationDay.creat();
                break;
            case 2:
                CreateEmployee createEmployee = new CreateEmployee();
                createEmployee.consoleEmployeeData();
                break;

            case 3:
                DeleteEmployee deleteEmployee = new DeleteEmployee();
                deleteEmployee.delete();
                break;

            case 4:
                CreateTeam createTeam = new CreateTeam();
                createTeam.create();
                break;

            case 5:
                DeleteTeam deleteTeam = new DeleteTeam();
                deleteTeam.deleteTeam();
                break;

            case 6:
                AddEmployeeToTeam addEmployeeToTeam = new AddEmployeeToTeam();
                addEmployeeToTeam.add();
                break;

            case 7:
                DeleteEmployeeFromTeam deleteEmployeeFromTeam = new DeleteEmployeeFromTeam();
                deleteEmployeeFromTeam.delete();
                break;

            case 8:
                SearchForEmployee searchForEmployee = new SearchForEmployee();
                searchForEmployee.search();
                break;

            case 9:
                PrintHolidayCalendar printHolidayCalendar = new PrintHolidayCalendar();
                printHolidayCalendar.print();
                break;

            case 10:
                PrintVacationForTeam printVacationForTeam = new PrintVacationForTeam();
                printVacationForTeam.print();
                break;

            default:
                break;

        }
    }
}


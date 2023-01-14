package com.isa.menu;

import com.isa.dataManager.DataManager;
import com.isa.model.Employee;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Iterator;
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
        while (value != 9) {
            printMenu();
            System.out.println("\nWybierz opcję za pomocą numeru: \n");
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
                consoleEmpData(value);
                if (getMenuItem(value) == null) {
                    throw new RuntimeException("Proszę podaj numer z zakresu przedstawionego w menu.");
                } else {
                    System.out.println(getMenuItem(value) + "\n");
                }
            } catch (InputMismatchException ex) {
                System.out.println("Podaj cyfrę.\n");
            } catch (RuntimeException ex) {
                System.out.println("Proszę podaj numer z zakresu przedstawionego w menu.");
            } catch (Exception e) {
                System.out.println("Niespotykany błąd.\n");
            }
        }
    }

    public void consoleEmpData(int value) {
        if (MenuList.ADD_EMPLOYEE.getPosition() == value) {
            while (true) {
                Employee employee = new Employee();
                employee.consoleEmployeeData();
                employee.toString();
                DataManager dataManager = new DataManager();
                dataManager.addEmployee(employee);
                System.out.println("Dodać kolejnego pracownika? (y/n)");
                Scanner scanner = new Scanner(System.in);
                String response = scanner.nextLine();
                if (response.equals("n")) {
                    break;
                }
            }
        }
    }
}


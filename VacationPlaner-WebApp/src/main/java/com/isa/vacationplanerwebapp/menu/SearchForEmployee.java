package com.isa.vacationplanerwebapp.menu;

import com.isa.vacationplanerwebapp.dataManager.DataManager;
import com.isa.vacationplanerwebapp.model.Employee;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SearchForEmployee {

    private final Scanner scanner = new Scanner(System.in);

    private final String[] searchOptions = {"IMIĘ", "NAZWISKO", "PESEL", "WSZYSTKO"};
    private final List<Employee> employees = DataManager.employeeList;

    public void search() {
        System.out.println("ZA POMOCĄ CZEGO CHCZESZ WYSZUKAĆ? \n 1-" + searchOptions[0] + " \n 2-" + searchOptions[1] + " \n 3-" + searchOptions[2] + " \n 4-" + searchOptions[3]);

        int value = getIntValue();
        if (value > 0 && value <= searchOptions.length) {
            search(value - 1);
        } else {
            System.out.println("PODAJ CYFRE Z OKREŚLONEGO PRZEDZIAŁU");
        }
    }

    private void search(int option) {
        String searchTerm = getSearchTerm();
        List<Employee> matches = search(option, searchTerm);
        if (matches.isEmpty()) {
            System.out.println("NIESTETY, NIE MA PRACOWNIKA KTÓRY ODPOWIADA TWOJEMU WYSZUKIWANIU");
        } else {
            for (Employee employee : matches) {
                System.out.println(employee);
            }
        }
    }

    private List<Employee> search(int option, String searchTerm) {
        return employees.stream().filter(employee -> match(option, employee, searchTerm)).collect(Collectors.toList());
    }
    private String getSearchTerm() {
        System.out.println("WPISZ FRAZE ZA POMOCĄ KTÓREJ CHCESZ WYSZUKAĆ:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private boolean match(int option, Employee employee, String searchTerm) {
        switch (option) {
            case 0:
                return employee.getName().toLowerCase().startsWith(searchTerm.toLowerCase());
            case 1:
                return employee.getSurname().toLowerCase().startsWith(searchTerm.toLowerCase());
            case 2:
                return employee.getPesel().toLowerCase().startsWith(searchTerm.toLowerCase());
            default:
                List<String> fields = Arrays.asList(employee.getName().toLowerCase(), employee.getSurname().toLowerCase(), employee.getPesel().toLowerCase(), employee.getPhoneNumber().toLowerCase(), employee.getAddress().toLowerCase(), employee.getTeam().toLowerCase(), employee.getEmail().toLowerCase());

                return fields.stream().anyMatch(field -> field.startsWith(searchTerm.toLowerCase()));
        }
    }

    private int getIntValue() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("PODAJ CYFRE");
            return -1;
        } catch (Exception e) {
            System.out.println("BŁĄD");
            return 0;
        }
    }
}

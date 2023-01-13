package com.isa.model;

import java.util.Scanner;

public class Employee {
    private String name;
    private String secondName;
    private String pesel;
    private String email;
    private String address;
    private String phoneNumber;

    public void consoleEmployeeData() {
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSecondName(secondName);
        employee.setAddress(address);
        employee.setPesel(pesel);
        employee.setEmail(email);
        employee.setPhoneNumber(phoneNumber);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Podaj imię pracownika");
        name = scanner.nextLine();
        System.out.println("Podaj nazwisko pracownika");
        secondName = scanner.nextLine();
        System.out.println("Podaj adres pracownika");
        address = scanner.nextLine();
        System.out.println("Podaj PESEL pracownika");
        while (true) {
            pesel = scanner.nextLine();
            if (pesel.length() == 11 && pesel.matches("[0-9]+")) {
                break;
            } else {
                System.out.println("Niepoprawny PESEL, PESEL powinien posiadać 11 cyfr.\nPodaj PESEL jeszcze raz.");
            }
        }
        System.out.println("Podaj email pracownika");
        email = scanner.nextLine();
        System.out.println("Podaj numer telefonu pracownika");
        while (true) {
            phoneNumber = scanner.nextLine();
            if (phoneNumber.length() == 9 && phoneNumber.matches("[0-9]+")){
                break;
            } else {
                System.out.println("Niepoprawny numer telefonu, numer telefonu powinien składać się z 9 cyfr.\nPodaj numer telefonu jeszcze raz.");
            }
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", secondName='" + secondName + '\'' +
                ", pesel='" + pesel + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}

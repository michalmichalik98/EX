package com.isa.menu;

public enum MenuList {

    ADD_VACATION_DAY(1, "DODAJ DZIEŃ URLOPOWY."),
    ADD_EMPLOYEE(2, "DODAJ PRACOWNIKA."),
    REMOVE_EMPLOYEE(3, "USUŃ PRACOWNIKA"),
    ADD_TEAM(4, "DODAJ ZESPÓŁ."),
    REMOVE_TEAM(5, "USUŃ ZESPÓŁ."),
    ADD_AND_REMOVE_EMPLOYEE_TO_TEAM(6, "DODAWANIE I USUWANIE PRACOWNIKA Z ZESPOŁU."),
    EMPLOYEE_SEARCH(7, "WYSZUKIWANIE PRACOWNIKÓW."),
    PRINT_HOLIDAY_CALENDAR(8, "WYŚWIETLANIE KALENDARZA ZE WSZYSTKIMI ŚWIĘTAMI"),
    VACATION_LIST_FOR_EVERY_TEAM(9, "PRZEGLĄDANIE WSZYSTKICH URLOPÓW PER ZESPÓŁ"),
    EXIT_PROGRAM(10, "ZAKOŃCZ DZIAŁANIE PROGRAMU.");

    private final int position;
    private final String description;

    MenuList(int position, String description) {
        this.position = position;
        this.description = description;
    }

    public int getPosition() {
        return position;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return position + " - " + description;
    }
}

package com.isa.menu;

public enum MenuList {

    ADD_VACATION_DAY(1, " DODAJ DZIEŃ URLOPOWY."),
    ADD_EMPLOYEE(2, " DODAJ PRACOWNIKA."),
    REMOVE_EMPLOYEE(3, " USUŃ PRACOWNIKA"),
    ADD_TEAM(4, " DODAJ ZESPÓŁ."),
    REMOVE_TEAM(5, " USUŃ ZESPÓŁ."),
    ADD_EMPLOYEE_TO_TEAM(6, " DODAWANIE PRACOWNIKA DO ZESPOŁU."),
    REMOVE_EMPLOYEE_FROM_TEAM(7, " USUWANIE PRACOWNIKA Z ZESPOŁU."),
    EMPLOYEE_SEARCH(8, " WYSZUKIWANIE PRACOWNIKÓW."),
    PRINT_HOLIDAY_CALENDAR(9, " WYŚWIETLANIE KALENDARZA ZE WSZYSTKIMI ŚWIĘTAMI"),
    VACATION_LIST_FOR_EVERY_TEAM(10, "PRZEGLĄDANIE WSZYSTKICH URLOPÓW PER ZESPÓŁ"),
    EXIT_PROGRAM(11, "ZAKOŃCZ DZIAŁANIE PROGRAMU.");

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

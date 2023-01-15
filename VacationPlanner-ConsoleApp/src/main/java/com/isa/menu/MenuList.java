package com.isa.menu;

public enum MenuList {

    ADD_VACATION_DAY(1, "DODAJ DZIEŃ URLOPOWY."),
    ADD_EMPLOYEE(2, "DODAJ PRACOWNIKA."),
    REMOVE_EMPLOYEE(3, "USUŃ PRACOWNIKA"),
    ADD_TEAM(4, "DODAJ ZESPÓŁ."),
    REMOVE_TEAM(5, "USUŃ ZESPÓŁ."),
    EXIT_PROGRAM(9, "ZAKOŃCZ DZIAŁANIE PROGRAMU.");

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

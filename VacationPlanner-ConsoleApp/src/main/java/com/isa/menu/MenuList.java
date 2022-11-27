package com.isa.menu;

public enum MenuList {

    ADD_VACATION_DAY(1, "Dodaj dzień urlopowy."),
    ADD_EMPLOYEE(2, "Dodaj Pracownika."),
    REMOVE_EMPLOYEE(2, "Usuń Pracownika"),
    ADD_TEAM(4, "Dodaj Zespół."),
    REMOVE_TEAM(5, "Usuń Zespół."),
    EXIT_PROGRAM(0, "Zakończ Działanie Programu.");

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
}

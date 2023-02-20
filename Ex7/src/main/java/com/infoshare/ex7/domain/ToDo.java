package com.infoshare.ex7.domain;

public class ToDo {


    private final String description;
    private final int priority;
    private final Category category;


    public ToDo(Category category, String description, int priority) {
        this.category = category;
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }

    public Category getCategory() {
        return category;
    }
    
   // @Override
   // public String toString() {
     //   return "Kategoria: " + category + ", " + "Opis: " + description +", " + "Priorytet: " + priority + "";
   // }
}

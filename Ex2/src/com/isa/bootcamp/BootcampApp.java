package com.isa.bootcamp;

public class BootcampApp {
    public static void main(String[] args) {

        Task ex1 = new Task();
        Task ex2 = new Task();
        ex1.setExnum("Ex1");
        ex1.setDescription("Podziel liczbe 4 przez liczbę 2 i podaj wynik.");
        ex1.setPoints(10);
        ex2.setExnum("Ex2");
        ex2.setDescription("Podaj wynik mnożenia liczb 6 i 3.");
        ex2.setPoints(10);


        Student ania = new Student();
        Student jan = new Student();

        ania.setName("Ania");
        ania.setSecondName("Nowak");
        ania.setGitHub("anianowak");
        jan.setName("Jan");
        jan.setSecondName("Kowalski");
        jan.setGitHub("jankowalski");

        Score max = new Score();
        Score min = new Score();

        min.setFeedBack("Zadanie oddane po terminie");
        max.setFeedBack("Zadnia wykonane bardzo dobrze");
        max.setPoints(10);
        min.setPoints(5);

        min.setStudent(ania);
        min.setStudent(jan);
        min.setTask(ex1);
        min.setTask(ex2);


        max.setStudent(ania);
        max.setStudent(jan);
        max.setTask(ex1);
        max.setTask(ex2);



        System.out.println();







    }
}

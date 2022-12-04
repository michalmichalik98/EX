package com.isa.lotto;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Drawing {
    public static int drawNumber = 0;
    public static int counter = 0;
    public static void getDraw() {
        int[] tab = new int[counter];
        Random random = new Random();
        draw:
        for (int number = 0; number < counter; number++) {
            int randomNumber = random.nextInt(drawNumber) + 1;
            for (int duplicate = 0; duplicate < number; duplicate++) {
                if (randomNumber == tab[duplicate]) {
                    --number;
                    continue draw;
                }
            }
            tab[number] = randomNumber;
            System.out.print(tab[number] + " ");

        }
    }

    public static void getData() {
        System.out.println("Podaj z jakiego zakresu wylosować liczby: ");
        Scanner scanner = new Scanner(System.in);

        try {
            drawNumber = scanner.nextInt();
            if (drawNumber < 0) throw new InputMismatchException();
            counter = scanner.nextInt();
            if (counter < 0) throw new InputMismatchException();
        } catch (InputMismatchException e) {
            System.out.println("Wprowdzono błędne dane!");
            getData();
        }
    }
}

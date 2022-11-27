package com.isa.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBehaviour {

    MenuList_old list = new MenuList_old();

    public void retrieveSelection() {


        int value = 0;
        boolean stayInLoop = true;
        do {
            list.printOption();
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
                behaviour(value);
                if (value == 0) {
                    stayInLoop = false;
                }
            } catch (InputMismatchException ex){
                System.out.println("Podaj cyfrę.\n");
            } catch (Exception e) {
                System.out.println("Niespotykany błąd.\n");
            }
        } while (stayInLoop);
    }

       public void behaviour(int value){
            switch (value) {
                case 1:
                    System.out.println("Dodaje Urlop.\n");
                    break;
                case 2:
                    System.out.println("Dodaje Pracownika.\n");
                    break;
                case 3:
                    System.out.println("Usuwam Pracownika.\n");
                    break;
                case 4:
                    System.out.println("Dodaje Zespół.\n");
                    break;
                case 5:
                    System.out.println("Usuwam Zespół.\n");
                    break;
                case 0:
                    System.out.println("Wychodzę!\n");
                    break;
                default:
                    System.out.println("Nie ma takiej opcji.\n");
                    break;

            }
    }
}

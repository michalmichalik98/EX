package com.isa.menu;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuBehaviour {

    public MenuList getMenuItem(int number){

        MenuList chooseToReturn = null;
        for(MenuList menuList: MenuList.values()){
            if(menuList.getPosition() == number){
                chooseToReturn = menuList;
            }
        }
        return chooseToReturn;
    }

    public void printMenu(){
        for (MenuList menuList : MenuList.values()){
            System.out.println(menuList);
        }
    }

    public void retrieveSelection() {

        int value = 0;
        boolean stayInLoop = true;
        while (!stayInLoop){
            printMenu();
            System.out.println("\nProszę wybierz opcję za pomocą numeru: \n");
            try {
                Scanner scanner = new Scanner(System.in);
                value = scanner.nextInt();
                getMenuItem(value);
                if (value == 0) {
                    stayInLoop = false;
                }
            } catch (InputMismatchException ex){
                System.out.println("Podaj cyfrę.\n");
            } catch (Exception e) {
                System.out.println("Niespotykany błąd.\n");
            }
        }
    }
}


package com.isa;

import com.isa.menu.MenuBehaviour;

public class App
{
    public static void main( String[] args )
    {


        System.out.println( "*Luz_Blue Team*" + "\n" + "Hello!" + "\n" + "Welcome to the VacationPlanner" );

        MenuBehaviour menu = new MenuBehaviour();
        menu.retrieveSelection();


    }
}

package com.isa;
import com.isa.dataManager.DataManager;
import com.isa.menu.MenuBehaviour;

public class App
{
    public static void main( String[] args )
    {
        DataManager.loadAllDataFromFile();

        System.out.println("Hello!" + "\n" + "Welcome to the VacationPlanner\n" );
        MenuBehaviour menu = new MenuBehaviour();
        menu.retrieveSelection();

        DataManager.saveAllDataToFile();

    }
}

/**
 * Main class is used to hold the main(String[] args) method so the program can run normally instead of using
 * the UnitTests class.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

import java.util.Scanner;

public class Main {

    //starts the program by creating a GarageManager object and prompting user input
    public static void main(String[] args){
        System.out.println("Welcome to your garage!");
        GarageManager manager = new GarageManager();
        manager.manageGarage(new Scanner(System.in));
    }
}

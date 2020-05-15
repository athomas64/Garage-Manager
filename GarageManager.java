/**
 * The GarageManager class is what edits and stores the user's list of vehicles. A linkedList of vehicles objects
 * stores the user's Truck and Car objects. Depending on user input the manageGarage method then either adds, removes,
 * sorts, or lists the user's vehicles.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

import java.util.LinkedList;
import java.util.Scanner;

public class GarageManager {

    // this field stores the users vehicles in their garage
    private LinkedList<Vehicle> vehicles;

    //default constructor
    public GarageManager(){
        vehicles = new LinkedList<>();
    }

    // method which prompts the user for input and then either adds, removes or sorts vehicles.
    public void manageGarage(Scanner scanner){
        System.out.println("'c' to add a car\n't' to add a truck\n'r' to remove a vehicle\n's' to sort your " +
                "vehicles\n" + "'q' to quit");
        String input = scanner.nextLine().toLowerCase();

        if(input.equals("q")){
            return;
        }

        switch (input){
            case "c":
                System.out.println("Enter the car's name and top speed (mph) separated by a comma");
                System.out.println(addVehicle(scanner.nextLine(), false));
                break;
            case "t":
                System.out.println("Enter the pickup truck's name and top speed (mph) separated by a comma");
                System.out.println(addVehicle(scanner.nextLine(), true));
                break;
            case "r":
                System.out.println("Please enter the top speed (mph) of the vehicle you want to remove");
                sortVehicles();
                System.out.println(removeVehicle(scanner.nextLine()));
                break;
            case "s":
                sortVehicles();
                System.out.println(printVehicles());
                break;
        }

        manageGarage(scanner);
    }

    // adds either a car or truck to the user's garage depending on the input. And returns a string output message.
    public String addVehicle(String input, boolean isTruck){

        try{
            Vehicle vehicle;
            String[] array = input.split(",");
            if(isTruck){
                vehicle = new Truck(array[0].trim(), (int) Double.parseDouble(array[1]));
            }else {
                vehicle = new Car(array[0].trim(), (int) Double.parseDouble(array[1]));
            }
            vehicles.add(vehicle);

            return vehicles.get(vehicles.size() - 1).getName() + " has been added to your garage";
        }
        catch (Exception e){
            return "Invalid input. Please try again";
        }

    }

    // Sorts the user's vehicles in order of slowest to fastest using an Insertion Sort. It returns a copy of the
    // user's garage
    public LinkedList<Vehicle> sortVehicles(){

        for (int i = 1; i < vehicles.size(); ++i) {
            int j = i;
            // Insert numbers[i] into sorted part
            // stopping once numbers[i] in correct position
            //while (j > 0 && sortedList.get(j).getWeight() < sortedList.get(j - 1).getWeight()) {
            while (j > 0 && !vehicles.get(j).compareWith(vehicles.get(j - 1))){

                // Swap numbers[j] and numbers[j - 1]
                Vehicle temp = vehicles.get(j);
                vehicles.set(j, vehicles.get(j - 1));
                vehicles.set(j - 1, temp);
                j--;
            }
        }

        return vehicles;
    }

    //Removes a vehicles based on it's top speed using a Binary Search. And returns a string output message.
    public String removeVehicle(String input){


        try{
            int speed = (int) Double.parseDouble(input);

            int result = binarySearch(vehicles, speed);

            if(result == -1){
                return "That vehicle could not be found in your garage";
            } else {
                Vehicle temp = vehicles.get(result);
                vehicles.remove(result);
                return temp.getName() + " has been removed from your garage";
            }

        }
        catch (Exception e){
            return "Invalid input. Please try again";
        }

    }

    // Binary Search which returns the index of the 'key' value given a LinkedList of vehicle objects
    public int binarySearch(LinkedList<Vehicle> vehicles, int key) {
        int mid = 0;
        int low = 0;
        int high = vehicles.size() - 1;

        while (high >= low) {
            mid = (high + low) / 2;
            if (vehicles.get(mid).getTopSpeed() < key) {
                low = mid + 1;
            }
            else if (vehicles.get(mid).getTopSpeed() > key) {
                high = mid - 1;
            }
            else {
                return mid;
            }
        }

        return -1;
    }

    // returns the string evaluation of the sorted list of vehicles objects to be printed to the user's screen
    public String printVehicles(){

        if(vehicles.size() == 0){
            return "You have no vehicles in your garage";

        }else{

            String output = "Your garage: (in order of slowest to fastest)\n";
            int i = 1;
            for(Vehicle vehicle : vehicles){
                output = output + (" " + i + ".  " + vehicle.toString() + "\n");
                i++;
            }

            return output;
        }

    }

}

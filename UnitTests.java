/**
 * The UnitTests has it's own main(String[] args) method which runs tests each class in the program.
 * The Unit Tests test each method independently and print the result.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

import java.util.LinkedList;

public class UnitTests {

    // tests each class's methods independently
    public static void main(String[] args){
        System.out.println("CAR CLASS TESTS: ");
        carTest();
        System.out.println("\nTRUCK CLASS TESTS:");
        truckTest();
        System.out.println("\nVEHICLE CLASS TESTS");
        vehicleTest();
        System.out.println("\nGARAGE_MANAGER CLASS TESTS");
        garageManagerTests();
    }

    // Car class method tests
    private static void carTest(){
        Car car = new Car("Ford Focus", 120);

        if(car.toString().equals("Ford Focus sedan that can go 120 mph on asphalt")){
            System.out.println("SUCCESS: car class toString method");
        }else{
            System.out.println("FAILED: car class toString method");
        }

        car = new Car("FordFocu    s234xxxxx", 12222220);

        if(car.toString().equals("FordFocu    s234xxxxx sedan that can go 12222220 mph on asphalt")){
            System.out.println("SUCCESS: car class toString method");
        }else{
            System.out.println("FAILED: car class toString method");
        }
    }

    // Truck class method tests
    private static void truckTest(){
        Truck truck = new Truck("Chevy Silverado", 110);

        if(truck.toString().equals("Chevy Silverado pickup truck that can go 110 mph off road")){
            System.out.println("SUCCESS: truck class toString method");
        }else{
            System.out.println("FAILED: truck class toString method");
        }

         truck = new Truck("dsgsdgbsd34", 0);

        if(truck.toString().equals("dsgsdgbsd34 pickup truck that can go 0 mph off road")){
            System.out.println("SUCCESS: truck class toString method");
        }else{
            System.out.println("FAILED: truck class toString method");
        }
    }

    // Vehicle abstract class method tests
    private static void vehicleTest(){
        Vehicle vehicle = new Car("Chevy 42gs fwe sddfsMalibu", -140);

        if(vehicle.getTopSpeed() == -140){
            System.out.println("SUCCESS: vehicle class getSpeed method");
        }else{
            System.out.println("FAILED: vehicle class getSpeed method");
        }

        if(vehicle.getName().equals("Chevy 42gs fwe sddfsMalibu")){
            System.out.println("SUCCESS: vehicle class getName method");
        }else{
            System.out.println("FAILED: vehicle class getName method");
        }

        if(!vehicle.compareWith(new Car("Test Car", 40))){
            System.out.println("SUCCESS: vehicle class compareWith method");
        }else{
            System.out.println("FAILED: vehicle class compareWith method");
        }
    }

    // GarageManager class method tests
    private static void garageManagerTests(){

        GarageManager garageManager = new GarageManager();

        LinkedList<Vehicle> numbers = new LinkedList<>();
        numbers.add(new Car("", 2));
        numbers.add(new Car("", 3));
        numbers.add(new Car("", 4));
        numbers.add(new Car("", 6));
        if(garageManager.binarySearch(numbers, 5) == -1){
            System.out.println("SUCCESS: garageManager class binarySearch method");
        }else{
            System.out.println("FAILED: garageManager class binarySearch method");
        }
        if(garageManager.binarySearch(numbers, 4) == 2){
            System.out.println("SUCCESS: garageManager class binarySearch method");
        }else{
            System.out.println("FAILED: garageManager class binarySearch method");
        }

        if(garageManager.printVehicles().equals("You have no vehicles in your garage")){
            System.out.println("SUCCESS: garageManager class printVehicles method");
        }else{
            System.out.println("FAILED: garageManager class printVehicles method");
        }

        if(garageManager.addVehicle("Ford Focus 125", false).equals("Invalid input. Please try again")){
            System.out.println("SUCCESS: garageManager class addVehicle method");
        }else{
            System.out.println("FAILED: garageManager class addVehicle method");
        }

        if(garageManager.addVehicle("Ford Focus, 6.057483", false).equals("Ford Focus" +
                " has been added to your garage")){
            System.out.println("SUCCESS: garageManager class addVehicle method");
        }else{
            System.out.println("FAILED: garageManager class addVehicle method");
        }

        garageManager.addVehicle("Ford F-150, 60", true);
        if(garageManager.removeVehicle("60").equals("Ford F-150 has been removed from your garage")){
            System.out.println("SUCCESS: garageManager class removeVehicle method");
        }else{
            System.out.println("FAILED: garageManager class removeVehicle method");
        }

        if(garageManager.removeVehicle("60").equals("That vehicle could not be found in your garage")){
            System.out.println("SUCCESS: garageManager class removeVehicle method");
        }else{
            System.out.println("FAILED: garageManager class removeVehicle method");
        }

        garageManager.addVehicle(", 2", false);
        garageManager.addVehicle(", 3", false);
        garageManager.addVehicle(", 4", false);
        garageManager.addVehicle(", 6", false);
        if(garageManager.sortVehicles().get(0).getTopSpeed() == 2){
            System.out.println("SUCCESS: garageManager class sortVehicle method");
        }else{
            System.out.println("FAILED: garageManager class sortVehicle method");
        }

    }



}

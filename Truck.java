/**
 * Truck is a class that extends Vehicle. Truck passes parameters to the super constructor and overrides the toString
 * method which is used to print the truck's information. Truck is a type of item listed as the user's the 'vehicles'.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

public class Truck extends Vehicle {

    // passes parameters to the super constructor in the Vehicle class
    public Truck(String title, int speed) {
        super(title, speed);
    }

    // overridden toString method used to print the truck's information for the user
    @Override
    public String toString(){
        return name + " pickup truck that can go " + topSpeed + " mph off road";
    }
}

/**
 * Car is a class that extends Vehicle. Car passes parameters to the super constructor and overrides the toString
 * method which is used to print the cars information. Car is a type of item listed as the user's the 'vehicles'.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

public class Car extends Vehicle {

    // passes parameters to the super constructor in the Vehicle class
    public Car(String title, int speed) {
        super(title, speed);
    }

    // overridden toString method used to print the car's information for the user
    @Override
    public String toString(){
        return name + " sedan that can go " + topSpeed + " mph on asphalt";
    }
}

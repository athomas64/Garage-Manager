/**
 * Vehicle is an abstract class that serves as a parent class for any class that is a part of the user's list of
 * vehicles. The class implements the generic Sortable interface and implements the compareWith method to compare
 * the speed variables of any object's of type Vehicle.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

public abstract class Vehicle implements Sortable<Vehicle>{
    protected int topSpeed;
    protected String name;

    // constructor that initializes the vehicle's name and top speed
    public Vehicle(String name, int topSpeed) {
        this.name = name;
        this.topSpeed = topSpeed;
    }

    // overridden method from the Sortable interface that compares two Vehicle type's speed
    @Override
    public boolean compareWith(Vehicle listItem) {

        if(topSpeed > listItem.getTopSpeed()){
            return true;
        }

        return false;
    }

    // getter for the topSpeed field
    public int getTopSpeed(){
        return topSpeed;
    }

    //getter for the name field
    public String getName(){
        return name;
    }

}

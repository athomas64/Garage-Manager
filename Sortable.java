/**
 * This generic interface has one method that compares two objects of the implemented type E. This method is used in
 * my program to compare the top speeds of two 'vehicle' objects.
 *
 * JDK version: 11.0.5
 *
 * @author  Aidan Thomas
 * @version 1.0.0
 * @since   05-14-2020
 */

public interface Sortable<E> {

    // generic method parameter used to compare two of any type of objects
    public boolean compareWith(E listItem);

}

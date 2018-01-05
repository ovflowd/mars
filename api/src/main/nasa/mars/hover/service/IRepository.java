package nasa.mars.hover.service;

import java.util.List;

/**
 * IRepository
 *
 * Used to store specific kind of Models
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
public interface IRepository<T> {

    /**
     * Add a new Object to the IRepository
     *
     * @param o Desired object to be added
     */
    T add(T o);

    /**
     * Remove an Object from the IRepository
     *
     * @param o Desired object to be removed
     */
    void remove(String o);

    /**
     * Build an Object and add it to the Repository
     *
     * @param o The IBuilder Class
     * @return Builded Object
     */
    T build(IBuilder<T> o);

    /**
     * Tries to get an Object from the Repository
     *
     * @param o A name of the Object
     *
     * @return The Object if found, null otherwise
     */
    T get(String o);

    /**
     * Get All Objects
     *
     * @return A list of all Objects from the IRepository
     */
    List<T> all();

    /**
     * Check if the Element exists in the IRepository
     *
     * @param o Element to be checked
     * @return If the element exists or not
     */
    boolean exists(String o);
}

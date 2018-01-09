package nasa.mars.hover.service;

/**
 * Iterator
 *
 * Used to Iterate through Objects
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
public interface Iterator<T, R> {

    /**
     * Set the Predicated Manipulator
     *
     * @param r the Manipulator
     */
    void predicate(R r);

    /**
     * Iterate through T object
     *
     * @param t Iteration List
     */
    void iterate(T t);
}

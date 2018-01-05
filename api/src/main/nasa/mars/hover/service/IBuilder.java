package nasa.mars.hover.service;

/**
 * IBuilder Interface
 *
 * Used to build specific Objects
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
public interface IBuilder<T> {

    /**
     * Build a T object
     *
     * @return Built Object
     */
    T build();
}

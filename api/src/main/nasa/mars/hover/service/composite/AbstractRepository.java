package nasa.mars.hover.service.composite;

import nasa.mars.hover.service.IBuilder;
import nasa.mars.hover.service.IRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Abstract Repository
 * <p>
 * An Abstract Representation of a Repository
 * Design Pattern
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.2
 */
public abstract class AbstractRepository<T> implements IRepository<T> {

    /**
     * A HashMap of a <T> object.
     */
    HashMap<String, T> items;

    /**
     * Remove a <T> element from the HashMap
     *
     * @param attribute element to be removed
     * @return if removed with success
     */
    @Override
    public boolean remove(String attribute) {
        return items.remove(attribute) != null;
    }

    /**
     * Build a <T> based on a <T> Builder
     *
     * @param o The IBuilder Class
     * @return Built <T>
     */
    @Override
    public T build(IBuilder<T> o) {
        return add(o.build());
    }

    /**
     * Tries to get a <T> from the HashMap
     *
     * @param attribute <T> attribute
     * @return The <T> if found, otherwise null
     */
    @Override
    public T get(String attribute) {
        return items.getOrDefault(attribute, null);
    }

    /**
     * Get all <T> as a List
     *
     * @return A List of all stored <T>
     */
    @Override
    public List<T> all() {
        return new ArrayList<>(items.values());
    }

    /**
     * Check if the Element exists in the HashMap
     *
     * @param name <T> to be checked
     * @return If the <T> exists or not
     */
    @Override
    public boolean exists(String name) {
        return items.containsKey(name);
    }

    /**
     * Clears the HashMap
     */
    @Override
    public void clear() {
        this.items.clear();
    }
}

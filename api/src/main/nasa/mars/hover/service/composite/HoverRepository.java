package nasa.mars.hover.service.composite;

import nasa.mars.hover.model.Hover;
import nasa.mars.hover.service.IBuilder;
import nasa.mars.hover.service.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hover Repository
 *
 * Used to store many Hovers
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@Repository
public class HoverRepository implements IRepository<Hover> {

    /**
     * An ArrayList of Hover that are stored
     *  on this Repository
     */
    private HashMap<String, Hover> items;

    /**
     * Create a new Instance of the Hover Repository
     */
    public HoverRepository() {
        this.items = new HashMap<>();
    }

    /**
     * Add a new Hover to the Repository
     *
     * @param hover Hover to be added
     */
    @Override
    public Hover add(Hover hover) {
        if(items.containsKey(hover.name))
            throw new RuntimeException("Hover Repository already contains the desired Hover");

        items.put(hover.name, hover);

        return hover;
    }

    /**
     * Remove a Hover from the Repository
     *
     * @param name Hover to be removed
     */
    @Override
    public void remove(String name) {
        items.remove(name);
    }

    /**
     * Build a Hover and add it to the repository
     *
     * @param o The IBuilder Class
     * @return Built Hover
     */
    @Override
    public Hover build(IBuilder<Hover> o) {
        return add(o.build());
    }

    /**
     * Tries to get a Hover from the Repository
     *
     * @param name Name of the Hover
     *
     * @return The Hover if found, otherwise null
     */
    @Override
    public Hover get(String name) {
        return items.getOrDefault(name, null);
    }

    /**
     * Get All Hovers
     *
     * @return A List of all stored Hovers
     */
    @Override
    public List<Hover> all() {
        return new ArrayList<>(items.values());
    }

    /**
     * Check if the Element exists in the IRepository
     *
     * @param name Hover to be checked
     * @return If the Hover exists or not
     */
    @Override
    public boolean exists(String name) {
        return items.containsKey(name);
    }

    /**
     * Get All Hovers from the Repository by
     *  their respective Maps
     *
     * @param name The name of the Map
     * @return A List of Hovers by Map
     */
    public List<Hover> getByMap(String name) {
        return all().stream().filter(h -> h.map.name.equals(name)).collect(Collectors.toList());
    }

    /**
     * Remove all Hovers from the Repository
     */
    @Override
    public void clear() {
        this.items.clear();
    }
}

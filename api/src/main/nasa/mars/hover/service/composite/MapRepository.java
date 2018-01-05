package nasa.mars.hover.service.composite;

import nasa.mars.hover.model.Map;
import nasa.mars.hover.service.IBuilder;
import nasa.mars.hover.service.IRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Map Repository
 *
 * Used to store many Maps
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@Repository
public class MapRepository implements IRepository<Map> {

    /**
     * An ArrayList of Maps that are stored
     *  on this Repository
     */
    private HashMap<String, Map> items;

    /**
     * Create a new Instance of the Map Repository
     */
    public MapRepository() {
        this.items = new HashMap<>();
    }

    /**
     * Add a new Map to the Repository
     *
     * @param map Map to be added
     */
    @Override
    public Map add(Map map) {
        if(items.containsKey(map.name))
            throw new RuntimeException("Map Repository already contains the desired Map");

        items.put(map.name, map);

        return map;
    }

    /**
     * Remove a Map from the Repository
     *
     * @param name Map to be removed
     */
    @Override
    public void remove(String name) {
        items.get(name).unlink();

        items.remove(name);
    }

    /**
     * Build a Map and add it to the repository
     *
     * @param o The IBuilder Class
     * @return Built Map
     */
    @Override
    public Map build(IBuilder<Map> o) {
        return add(o.build());
    }

    /**
     * Tries to get a Map from the Repository
     *
     * @param name Name of the Map
     *
     * @return The Map if found, otherwise null
     */
    @Override
    public Map get(String name) {
        return items.getOrDefault(name, null);
    }

    /**
     * Get All Maps
     *
     * @return A List of all stored Maps
     */
    @Override
    public List<Map> all() {
        return new ArrayList<>(items.values());
    }

    /**
     * Check if the Element exists in the IRepository
     *
     * @param name Map to be checked
     * @return If the Map exists or not
     */
    @Override
    public boolean exists(String name) {
        return items.containsKey(name);
    }
}

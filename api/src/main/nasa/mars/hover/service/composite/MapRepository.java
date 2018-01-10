package nasa.mars.hover.service.composite;

import nasa.mars.hover.model.Map;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

/**
 * Map Repository
 * <p>
 * Used to store many Maps
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
@Repository
public class MapRepository extends AbstractRepository<Map> {

    /**
     * Create a new Instance of the Map Repository
     * and instantiate a new HashMap
     */
    public MapRepository() {
        this.items = new HashMap<>();
    }

    /**
     * Add a new Map to the HashMap
     * <p>
     * Note.: If element already exists,
     * it will be replaced.
     *
     * @param map Map to be added
     */
    @Override
    public Map add(Map map) {
        items.put(map.name, map);

        return map;
    }

    /**
     * Remove a Map from the HashMap
     * and also unlink the Hovers
     *
     * @param name Map to be removed
     * @return if removed with success
     */
    @Override
    public boolean remove(String name) {
        items.get(name).unlink();

        return items.remove(name) != null;
    }
}

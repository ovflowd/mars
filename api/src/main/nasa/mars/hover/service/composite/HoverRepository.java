package nasa.mars.hover.service.composite;

import nasa.mars.hover.model.Hover;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Hover Repository
 * <p>
 * Used to store many Hovers
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
@Repository
public class HoverRepository extends AbstractRepository<Hover> {

    /**
     * Creates a new Instance of the Hover Repository
     * and instantiate a new HashMap
     */
    public HoverRepository() {
        this.items = new HashMap<>();
    }

    /**
     * Add a new Hover to the HashMap
     * <p>
     * Note.: If element already exists,
     * it will be replaced.
     *
     * @param hover Hover to be added
     */
    @Override
    public Hover add(Hover hover) {
        items.put(hover.name, hover);

        return hover;
    }

    /**
     * Get All Hovers from the Repository by
     * their respective Maps
     *
     * @param name The name of the Map
     * @return A List of Hovers by Map
     */
    public List<Hover> getByMap(String name) {
        return all().stream().filter(h -> h.map != null && h.map.name.equals(name)).collect(Collectors.toList());
    }
}

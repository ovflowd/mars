package nasa.mars.hover.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.io.Serializable;

/**
 * Hover Domain Entity
 *
 * This "memory based" entity would contain our Hover entities
 * @version 1.0
 * @author @sant0ro
 */
@Configurable
public class Hover implements Serializable {

    /**
     * The Hover Name, because we want "Social" hovers, right?
     */
    public final String name;

    /**
     * The current Coordinate in the Map where the Hover belongs.
     */
    @Autowired
    private Coordinate coordinate;

    /**
     * The Current Map that the Hoer it's placed
     */
    public Map map;

    /**
     * Create a new Hover
     *
     * @param name A name for the Hover
     */
    public Hover(String name) {
        this.name = name;
    }

    /**
     * Create a new Hover
     *
     * @param name A name for the Hover
     * @param map Initial Map
     */
    public Hover(String name, Map map) {
        this.name = name;
        this.map = map;
    }

    /**
     * Get the Coordinate of the Hover
     *
     * @return Coordinate of the Hover
     */
    public Coordinate coordinate() {
        return coordinate;
    }
}

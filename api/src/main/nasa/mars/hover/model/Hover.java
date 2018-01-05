package nasa.mars.hover.model;

import nasa.mars.hover.model.enumerator.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;

/**
 * Hover Domain Entity
 *
 * This "memory based" entity would contain our Hover entities
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@Component
@Scope("prototype")
public class Hover implements Serializable {

    /**
     * The Hover Name, because we want "Social" hovers, right?
     */
    public String name;

    /**
     * When the Hover was Launched
     */
    public Date launch;

    /**
     * The Mission Status of the Hover
     */
    public Mission status;

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

        this.coordinate = new Coordinate();
    }

    /**
     * Create a new Hover
     *
     * @param name Hover Name
     * @param launch Launch Date
     * @param status Mission Status
     */
    public Hover(String name, Date launch, Mission status) {
        this.name = name;
        this.launch = new Date();
        this.status = Mission.STARTED;

        this.coordinate = new Coordinate();
    }

    /**
     * Create a new Default Hover
     */
    @Autowired
    public Hover(Coordinate c) {
        this.name = "Default Hover";
        this.launch = new Date();
        this.status = Mission.STARTED;

        this.coordinate = c;
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

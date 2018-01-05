package nasa.mars.hover.model;

import nasa.mars.hover.model.enumerator.Cardinal;
import nasa.mars.hover.service.iterator.GeoReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;

/**
 * Hover Coordinate Utility
 *
 * This is a Coordinate on our Map
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@Component
public class Coordinate extends Point implements Serializable {

    /**
     * The heading of the Hover in our Map
     */
    @Autowired
    public Cardinal heading;

    /**
     * GeoReference Instance
     */
    @Autowired
    public final GeoReference reference;

    /**
     * Create a new Coordinate that can be stored on our Map
     */
    @Autowired
    public Coordinate(GeoReference reference) {
        this.reference = reference;
        this.reference.setCoordinate(this);
    }

    /**
     * Get the Coordinate Dynamic String
     *
     * @return dynamic coordinate string
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + heading.getCode() + ')';
    }

    /**
     * Reset the Coordinate Attributes
     *  to their default value
     */
    public void reset() {
        this.move(0,0);

        this.heading = Cardinal.NORTH;
    }

    /**
     * Update the Coordinate data and return it
     *
     * @param x The new X position
     * @param y The new Y position
     * @param cardinal The Cardinal Heading
     * @return This instane
     */
    public Coordinate update(int x, int y, Cardinal cardinal) {
        this.heading = cardinal;

        this.x = x;
        this.y = y;

        return this;
    }
}

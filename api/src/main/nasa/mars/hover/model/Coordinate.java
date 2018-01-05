package nasa.mars.hover.model;

import nasa.mars.hover.model.enumerator.Cardinal;
import org.springframework.context.annotation.Scope;
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
@Scope("prototype")
public class Coordinate extends Point implements Serializable {

    /**
     * The heading of the Hover in our Map
     */
    public Cardinal heading = Cardinal.NORTH;

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

        this.move(x, y);

        return this;
    }
}

package nasa.mars.hover.model;

import nasa.mars.hover.model.enumerator.Cardinal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * Hover Coordinate Utility
 * <p>
 * This is a Coordinate on our Map
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.0
 */
@Component
@Scope("prototype")
public class Coordinate extends Point {

    /**
     * The heading of the Hover in our Map
     */
    public Cardinal heading;

    /**
     * Creates a new Coordinate
     *
     * @param x        Desired X position
     * @param y        Desired Y position
     * @param cardinal the Cardinal instance
     */
    public Coordinate(int x, int y, Cardinal cardinal) {
        this.move(x, y);

        this.heading = cardinal;
    }

    /**
     * Creates a new Coordinate
     */
    @Autowired
    public Coordinate() {
        this.move(0, 0);

        this.heading = Cardinal.NORTH;
    }

    /**
     * Get the Coordinate Dynamic String
     *
     * @return dynamic point string
     */
    public String toString() {
        return "(" + this.x + ", " + this.y + ", " + heading.getCode() + ')';
    }

    /**
     * Reset the Coordinate Attributes
     * to their default value
     */
    public void reset() {
        this.move(0, 0);

        this.heading = Cardinal.NORTH;
    }

    /**
     * Update the Coordinate data and return it
     *
     * @param x        The new X position
     * @param y        The new Y position
     * @param cardinal The Cardinal Heading
     * @return This instane
     */
    public Coordinate update(int x, int y, Cardinal cardinal) {
        this.heading = cardinal;

        this.move(x, y);

        return this;
    }
}

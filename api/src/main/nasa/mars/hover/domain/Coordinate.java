package nasa.mars.hover.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;

/**
 * Hover Coordinate Utility
 *
 * This is a Coordinate on our Map
 * @version 1.0
 * @author @sant0ro
 */
@Component
public class Coordinate implements Serializable {

    /**
     * The X,Y Coordinate Point
     */
    public final Point position;

    /**
     * The heading of the Hover in our Map
     */
    public int heading;

    /**
     * GeoReference Instance
     */
    public final GeoReference reference;

    /**
     * Create a new Coordinate that can be stored on our Map
     *
     * @param x the desired X position in our Map
     * @param y the desired Y position in our Map
     * @param h the Hover heading
     * @param g GeoReference instance
     */
    public Coordinate(int x, int y, int h, GeoReference g) {
        this.position = new Point(x, y);
        this.heading = h;

        this.reference = g;
    }

    /**
     * Create a new Coordinate that can be stored on our Map
     *
     * @param p the Point Coordinate (X,Y)
     * @param h the Hover heading
     * @param g GeoReference instance
     */
    public Coordinate(Point p, int h, GeoReference g) {
        this.position = p;
        this.heading = h;

        this.reference = g;
    }

    /**
     * Create a new Coordinate that can be stored on our Map
     */
    @Autowired
    public Coordinate() {
        this.position = new Point(0, 0);
        this.heading = GeoReference.NORTH;

        this.reference = new GeoReference(this);
    }

    /**
     * Get the Coordinate Dynamic String
     *
     * @return dynamic coordinate string
     */
    public String toString() {
        return "(" + this.position.x + ", " + this.position.y + ", " + reference.headingCode() + ')';
    }

    /**
     * Reset the Coordinate Attributes
     *  to their default value
     */
    public void reset() {
        this.position.move(0,0);
        this.heading = GeoReference.NORTH;
    }
}

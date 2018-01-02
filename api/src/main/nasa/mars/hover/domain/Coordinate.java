package nasa.mars.hover.domain;

import java.awt.*;

/**
 * Hover Coordinate Utility
 *
 * This is a Coordinate on our Map
 * @version 1.0
 * @author @sant0ro
 */
public class Coordinate {

    /**
     * The X,Y Coordinate Point
     */
    public final Point position;

    /**
     * The heading of the Hover in our Map
     */
    public final GeoReference heading;

    /**
     * Create a new Coordinate that can be stored on our Map
     *
     * @param x the desired X position in our Map
     * @param y the desired Y position in our Map
     * @param h the Hover heading
     */
    public Coordinate(int x, int y, GeoReference h) {
        this.position = new Point(x, y);
        this.heading = h;
    }

    /**
     * Create a new Coordinate that can be stored on our Map
     *
     * @param p the Point Coordinate (X,Y)
     * @param h the Hover heading
     */
    public Coordinate(Point p, GeoReference h) {
        this.position = p;
        this.heading = h;
    }
}

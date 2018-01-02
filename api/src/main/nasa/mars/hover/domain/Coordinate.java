package nasa.mars.hover.domain;

/**
 * Hover Coordinate Utility
 *
 * This is a Coordinate on our Map
 * @version 1.0
 * @author @sant0ro
 */
public class Coordinate {

    /**
     * The X coordinate in our Map
     */
    public final Integer x;

    /**
     * the Y coordinate in our Map
     */
    public final Integer y;

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
        this.x = x;
        this.y = y;
        this.heading = h;
    }
}

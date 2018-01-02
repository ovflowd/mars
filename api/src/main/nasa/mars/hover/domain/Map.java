package nasa.mars.hover.domain;

/**
 * Map Class
 *
 * Used as 2D Map Definition
 *
 * Notes.: this is an 2D Game Map, emulating a 3D User Vector,
 *  where the Vector itself contains (X, Y, Heading).
 *
 * Notes.: In this scenario we will create a real world scenario,
 *  based for network usage, and multiple hovers, even, if the API
 *  would only handle an unique hover.
 *
 * @version 1.0
 * @author @sant0ro
 */
public class Map {

    /**
     * Map size in terms of X coordinate
     * In other words: length
     */
    public final int xBounds = 5;

    /**
     * Map size in terms of Y coordinate
     * In other words: width
     */
    public final int yBounds = 5;

    /**
     * The Name of the Map
     * Used for Identification
     */
    public final String name = "Mars";
}

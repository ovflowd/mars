package nasa.mars.hover.domain;

import nasa.mars.hover.Boot;
import nasa.mars.hover.util.PathFinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.awt.*;
import java.io.Serializable;
import java.util.NoSuchElementException;

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
 *  Note.: A Hover can only be assigned to a single Map
 *
 * @version 1.0
 * @author @sant0ro
 */
@Configurable
public class Map implements Serializable {

    /**
     * Map size in terms of X coordinate
     * In other words: length/height
     */
    public final int xBounds;

    /**
     * Map size in terms of Y coordinate
     * In other words: width
     */
    public final int yBounds;

    /**
     * The Name of the Map
     * Used for Identification
     */
    public final String name;

    /**
     * Each PathFinder it's associated to a Map, to calculate
     *  the own Map Paths.
     */
    @Autowired
    private final PathFinder pathFinder;

    /**
     * Our Application Engine
     */
    @Autowired
    private Boot boot;

    /**
     * Creates a New Map
     *
     * @param name the name of the Map
     * @param x the length of the map
     * @param y the width of the map
     */
    public Map(String name, int x, int y) {
        this.name = name;
        this.xBounds = x;
        this.yBounds = y;

        pathFinder = new PathFinder(this);
    }

    /**
     * Creates a New Map
     *
     * @param name the name of the Map
     * @param x the length of the map
     * @param y the width of the map
     * @param pathFinder An injected PathFinder instance
     */
    public Map(String name, int x, int y, PathFinder pathFinder) {
        this.name = name;
        this.xBounds = x;
        this.yBounds = y;

        this.pathFinder = pathFinder;
    }

    /**
     * Update the Position of the Hover
     *
     * @param hover the desired Hover
     * @param c the desired Coordinate
     *
     * @return If the Path is valid and got successful update
     */
    public boolean updateCoordinate(Hover hover, Coordinate c) {
        if(hover == null || !pathFinder.checkPath(c.position))
            return false;

        hover.coordinate().position.move(c.position.x, c.position.y);

        hover.coordinate().heading = c.heading;

        return true;
    }

    /**
     * Update the Position of the Hover
     *
     * @param name the Hover name
     * @param c the desired Coordinate
     */
    public boolean updateCoordinate(String name, Coordinate c) {
        return updateCoordinate(boot.getHover(name), c);
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     *
     * Note.: this automatically removes the link of the Hover
     *  from the last map
     *
     * @param hover the desired Hover
     */
    public void addHover(Hover hover) {
        hover.map = this;
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     *
     * @param name The Hover name
     */
    public void addHover(String name) {
        addHover(boot.getHover(name));
    }

    /**
     * Remove the Hover from the Map and erase it's position
     *
     * @param hover The current Hover
     */
    public void removeHover(Hover hover) {
        hover.coordinate().reset();

        hover.map = null;
    }

    /**
     * Remove the Hover from the Map and reset it's position to the initial position
     *
     * @param name The Hover name
     */
    public void removeHover(String name) {
        removeHover(boot.getHover(name));
    }

    /**
     * Check if the specified Hover belongs to this ap
     *
     * @param h Specified Hover
     * @return If belongs or not
     */
    private boolean belongsTo(Hover h) {
        return h != null && h.map.equals(this);
    }

    /**
     * Get a Hover in this Map
     *
     * @param name The Name of the Hover
     * @return The desired Hover or null if it doesn't exists in this map.
     */
    public Hover getHover(String name) {
        return boot.getHovers(this).stream().filter(h -> h.name.equals(name)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Get a Hover by a Point, also useful to check if exists a Hover in a
     *  specific Point.
     *
     * @param p the desired Point
     * @return The Hover instance if found, or null if not.
     */
    public Hover getHover(Point p) {
        return boot.getHovers(this).stream().filter(h -> h.coordinate().position.equals(p)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Get a Hover by a Point, also useful to check if exists a Hover in a
     *  specific Point.
     *
     * @param x the X position
     * @param y the Y position
     * @return The Hover instance if found, or null if not.
     */
    public Hover getHover(int x, int y) {
        return getHover(new Point(x, y));
    }

    /**
     * Get a Hover by a Point, also useful to check if exists a Hover in a
     *  specific Point.
     *
     * @param c a given Coordinate
     * @return The Hover instance if found, or null if not.
     */
    public Hover getHover(Coordinate c) {
        return getHover(c.position);
    }
}

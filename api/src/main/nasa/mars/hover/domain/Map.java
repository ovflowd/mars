package nasa.mars.hover.domain;

import nasa.mars.hover.Boot;
import nasa.mars.hover.util.PathFinder;

import java.awt.*;
import java.util.ArrayList;

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
public class Map {

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
    private PathFinder pathFinder;

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

        this.pathFinder = new PathFinder(this);
    }

    /**
     * Get the Path Finder of the linked Map
     *
     * @return a PathFinder instance
     */
    public PathFinder getPathFinder() {
        return pathFinder;
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     *
     * @param temporary the desired Hover
     * @throws Exception if the Hover isn't found or already in a Map
     */
    public void addHover(Hover temporary) throws Exception {
        if(temporary == null)
            throw new Exception("Hover not found, cannot add it to the Map");

        if(temporary.getCurrentMap() != null)
            throw new Exception("Hover already linked to a specific Map.");

        temporary.setPosition(0, 0);

        temporary.setCurrentMap(this);
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     *
     * @param name The Hover name
     * @throws Exception if the Hover isn't found or already in a Map
     */
    public void addHover(String name) throws Exception {
        this.addHover(Boot.getGame().getHover(name));
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     *
     * @param id The Hover Identifier
     * @throws Exception if the Hover isn't found or already in a Map
     */
    public void addHover(int id) throws Exception {
        this.addHover(Boot.getGame().getHover(id));
    }

    /**
     * Remove the Hover from the Map and erase it's position
     *
     * @param h The current Hover
     */
    private void removeHover(Hover h) {
        if(h == null)
            return;

        h.setPosition(null);

        h.setCurrentMap((Map) null);
    }

    /**
     * Remove the Hover from the Map and reset it's position to the initial position
     *
     * @param name The Hover name
     */
    public void removeHover(String name) {
        this.removeHover(Boot.getGame().getHover(name));
    }

    /**
     * Remove the Hover from the Map and reset it's position to the initial position
     *
     * @param id The Hover Identifier
     */
    public void removeHover(int id) {
        this.removeHover(Boot.getGame().getHover(id));
    }

    /**
     * Get a Hover in this Map by the Hover name
     *
     * @param h The current Hover
     * @return The desired Hover or null if it doesn't exists in this map.
     */
    private Hover getHover(Hover h) {
        if(h == null || !h.getCurrentMap().name.equals(this.name))
            return null;

        return h;
    }

    /**
     * Get a Hover in this Map by the Hover name
     *
     * @param name The Name of the Hover
     * @return The desired Hover or null if it doesn't exists in this map.
     */
    public Hover getHover(String name) {
        return this.getHover(Boot.getGame().getHover(name));
    }

    /**
     * Get a Hover in this Map by the Hover Identifier
     *
     * @param id The Identifier of the Hover
     * @return The desired Hover or null if it doesn't exists in this map.
     */
    public Hover getHover(int id) {
        return this.getHover(Boot.getGame().getHover(id));
    }

    /**
     * Get a Hover by a Point, also useful to check if exists a Hover in a
     *  specific Point.
     *
     * @param p the desired Point
     * @return The Hover instance if found, or null if not.
     */
    public Hover getHover(Point p) {
        ArrayList<Hover> temporary = (ArrayList<Hover>) Boot.getGame().getHovers(this.name);

        if(temporary.isEmpty())
            return null;

        return temporary.stream().filter(h -> h.getPosition() == p).findFirst().orElse(null);
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
        return this.getHover(new Point(x, y));
    }

    /**
     * Get a Hover by a Point, also useful to check if exists a Hover in a
     *  specific Point.
     *
     * @param c a given Coordinate
     * @return The Hover instance if found, or null if not.
     */
    public Hover getHover(Coordinate c) {
        return this.getHover(c.position);
    }
}

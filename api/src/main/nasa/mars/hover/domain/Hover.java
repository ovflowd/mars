package nasa.mars.hover.domain;

import nasa.mars.hover.Boot;

import java.awt.*;

/**
 * Hover Domain Entity
 *
 * This "memory based" entity would contain our Hover entities
 * @version 1.0
 * @author @sant0ro
 */
public class Hover {

    /**
     * Unique Identifier of the Hover, usable for te PathFinder and
     *  future implementations of Data Store.
     */
    public final Integer id;

    /**
     * The Hover Name, because we want "Social" hovers, right?
     */
    public final String name;

    /**
     * The current Coordinate in the Map where the Hover belongs.
     */
    private final Coordinate coordinate = new Coordinate(0, 0, GeoReference.NORTH);

    /**
     * Since we don't want to do complex logic, why not just tell which map the Hover it's placed?
     */
    private Map currentMap = null;

    /**
     * Create a new Hover instance, specifying the ID, its name and current Position.
     *
     * @param id The Hover Unique Identifier
     * @param name The Hover name
     */
    public Hover(int id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * Get the Current Hover's Coordinate
     *
     * @return the current position
     */
    public Coordinate getCoordinate() {
        return coordinate;
    }

    /**
     * Get the Current Hover's Position
     *
     * @return the current position
     */
    public Point getPosition() {
        return coordinate.position;
    }

    /**
     * Update the Hover's Position
     *
     * @param p the new Coordinate Point
     */
    public void setPosition(Point p) {
        if(p == null)
            return;

        this.coordinate.position.move(p.x, p.y);
    }

    /**
     * Update the Hover's Position
     *
     * @param x the X position
     * @param y the Y position
     */
    public void setPosition(int x, int y) {
        this.coordinate.position.move(x, y);
    }

    /**
     * Get the Current Hover Map
     *
     * @return the Map instance or null if isn't linked in any map
     */
    public Map getCurrentMap() {
        return currentMap;
    }

    /**
     * Set the Current Map that te Hover belongs
     *
     * @param currentMap the Map name
     */
    public void setCurrentMap(String currentMap) throws Exception {
        Map temporary = Boot.getGame().getMap(currentMap);

        if(temporary == null)
            throw new Exception("The Map doesn't exists in this Game");

        this.currentMap = temporary;
    }

    /**
     * Set the Current Map that te Hover belongs
     *
     * @param currentMap the Map instance
     */
    public void setCurrentMap(Map currentMap) {
        this.currentMap = currentMap;
    }
}

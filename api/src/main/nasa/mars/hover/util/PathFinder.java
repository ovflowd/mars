package nasa.mars.hover.util;

import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.Map;

import java.awt.*;

/**
 * PathFinder Utility
 *
 * This class will contain a really simple Path Finder algorithm,
 * and for further usage we recommend the apply of real world algorithms like:
 *  A*, IDA*, Dijkstra, and others.
 *
 * Notes.: this class will validate user input and iterate between the Map.
 *
 * @see Map
 * @see Coordinate
 * @version 1.0
 * @author @sant0ro
 */
public class PathFinder {

    /**
     * The Map instance designated to this PathFinder
     */
    private final Map belongsTo;

    /**
     * Creates a New PathFinder Instance
     *
     * @param map the map that the PathFinder belongs
     */
    public PathFinder(Map map) {
        this.belongsTo = map;
    }

    /**
     * Check if the desired Path is valid
     *
     * @param p the desired Point
     * @return if is valid or not
     */
    public boolean checkPath(Point p) {
        return p.x >= 0 && p.y >= 0 && p.x < belongsTo.xBounds && p.y < belongsTo.yBounds && belongsTo.getHover(p) == null;
    }

    /**
     * Check if the desired Path is valid
     *
     * @param x the X position
     * @param y the Y position
     * @return if is valid or not
     */
    public boolean checkPath(int x, int y) {
        return this.checkPath(new Point(x, y));
    }
}

package nasa.mars.hover.util;

import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.io.Serializable;

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
@Component
public class PathFinder implements Serializable {

    /**
     * The Map instance designated to this PathFinder
     */
    private final Map map;

    /**
     * Creates a New PathFinder Instance
     *
     * @param map the map that the PathFinder belongs
     */
    @Autowired
    public PathFinder(Map map) {
        this.map = map;
    }

    /**
     * Check if the desired Path is valid
     *
     * @param p the desired Point
     * @return if is valid or not
     */
    public boolean checkPath(Point p) {
        return p.x >= 0 && p.y >= 0 && p.x < map.xBounds && p.y < map.yBounds && map.getHover(p) == null;
    }

    /**
     * Check if the desired Path is valid
     *
     * @param x the X position
     * @param y the Y position
     * @return if is valid or not
     */
    public boolean checkPath(int x, int y) {
        return checkPath(new Point(x, y));
    }
}

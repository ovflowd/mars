package nasa.mars.hover.model;

import nasa.mars.hover.Engine;
import nasa.mars.hover.model.enumerator.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
 * Note.: A Hover can only be assigned to a single Map
 *
 * @version 1.0
 * @author @sant0ro
 */
@Component
public class Map {

    /**
     * Map size in terms of X coordinate
     * In other words: length/height
     */
    public int height;

    /**
     * Map size in terms of Y coordinate
     * In other words: width
     */
    public int width;

    /**
     * The Name of the Map
     * Used for Identification
     */
    public String name;

    /**
     * Our Application Engine
     */
    @Autowired
    private Engine engine;

    /**
     * Creates a New Map
     *
     * @param engine Dependency Injection of Application Engine
     */
    public Map(Engine engine) {
        this.engine = engine;
    }

    /**
     * Update the Position of the Hover
     *
     * @param hover the desired Hover
     * @param c the desired Coordinate
     *
     * @return If the Path is valid and got successful update
     */
    public boolean move(Hover hover, Coordinate c) {
        if(hover == null || !valid(c.x, c.y))
            return false;

        hover.coordinate().move(c.x, c.y);

        hover.coordinate().heading = c.heading;

        hover.status = Mission.OPERATING;

        return true;
    }

    /**
     * Update the Position of the Hover
     *
     * @param name the Hover name
     * @param c the desired Coordinate
     */
    public boolean move(String name, Coordinate c) {
        return move(engine.getHovers().get(name), c);
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     *
     * Note.: this automatically removes the link of the Hover
     *  from the last map
     *
     * @param hover the desired Hover
     */
    public void link(Hover hover) {
        hover.map = this;

        hover.status = Mission.LANDED;
    }

    /**
     * Unlink a hover from the Map
     *
     * @param name A Hover Name
     */
    public void link(String name) {
        link(engine.getHovers().get(name));
    }

    /**
     * Unlink a hover from the Map
     *
     * @param hover A Hover
     */
    public void unlink(Hover hover) {
        hover.coordinate().reset();

        hover.map = null;

        hover.status = Mission.ENDED;
    }

    /**
     * Unlink all hovers from the Map
     */
    public void unlink() {
        engine.getHovers().getByMap(this.name).forEach(h -> h.map.unlink(h));
    }

    /**
     * Remove the Hover from the Map and reset it's position to the initial position
     *
     * @param name The Hover name
     */
    public void unlink(String name) {
        unlink(engine.getHovers().get(name));
    }

    /**
     * Check if the specified Hover belongs to this ap
     *
     * @param h Specified Hover
     * @return If belongs or not
     */
    public boolean exists(Hover h) {
        return h != null && h.map.equals(this);
    }

    /**
     * Get a Hover by a Point, also useful to check if exists a Hover in a
     *  specific Point.
     *
     * @param x the X position
     * @param y the Y position
     * @return The Hover instance if found, or null if not.
     */
    public boolean contains(int x, int y) {
        return engine.getHovers().getByMap(this.name).stream().anyMatch(h -> h.coordinate().x == x && h.coordinate().y == y);
    }

    /**
     * Check if the desired Path is valid
     *
     * @param x the X position
     * @param y the Y position
     * @return if is valid or not
     */
    public boolean valid(int x, int y) {
        return x >= 0 && y >= 0 && x < height && y < width && !contains(x, y);
    }
}

package nasa.mars.hover.model;

import nasa.mars.hover.Engine;
import nasa.mars.hover.model.enumerator.Mission;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * Map Class
 * <p>
 * Used as 2D Map Definition
 * <p>
 * Notes.: this is an 2D Game Map, emulating a 3D User Vector,
 * where the Vector itself contains (X, Y, Heading).
 * <p>
 * Notes.: In this scenario we will create a real world scenario,
 * based for network usage, and multiple hovers, even, if the API
 * would only handle an unique hover.
 * <p>
 * Note.: A Hover can only be assigned to a single Map
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.0
 */
@Component
@Scope("prototype")
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
     * @param c     the desired Coordinate
     * @return If the Path is valid and got successful update
     */
    public boolean move(Hover hover, Coordinate c) {
        if (hover == null || !valid(c.x, c.y))
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
     * @param c    the desired Coordinate
     */
    public boolean move(String name, Coordinate c) {
        return move(engine.getHovers().get(name), c);
    }

    /**
     * Add an Hover to the Map and set it Initial Position
     * <p>
     * Note.: this automatically removes the link of the Hover
     * from the last map
     *
     * @param hover the desired Hover
     * @return if linked with success
     */
    public boolean link(Hover hover) {
        if (hover == null || !valid(hover.coordinate().x, hover.coordinate().y))
            return false;

        hover.map = this;

        hover.status = Mission.LANDED;

        return true;
    }

    /**
     * Unlink a hover from the Map
     *
     * @param name A Hover Name
     * @return if linked with success
     */
    public boolean link(String name) {
        return link(engine.getHovers().get(name));
    }

    /**
     * Unlink a hover from the Map
     *
     * @param hover A Hover
     * @return if unlinked with success
     */
    public boolean unlink(Hover hover) {
        if (hover == null || !exists(hover))
            return false;

        hover.coordinate().reset();

        hover.map = null;

        hover.status = Mission.ENDED;

        return true;
    }

    /**
     * Remove the Hover from the Map and reset it's position to the initial position
     *
     * @param name The Hover name
     * @return if unlinked with success
     */
    public boolean unlink(String name) {
        return unlink(engine.getHovers().get(name));
    }

    /**
     * Unlink all hovers from the Map
     */
    public void unlink() {
        engine.getHovers().getByMap(this.name).forEach(h -> h.map.unlink(h));
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
     * specific Point.
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

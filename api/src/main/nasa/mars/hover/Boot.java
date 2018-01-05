package nasa.mars.hover;

import nasa.mars.hover.domain.Hover;
import nasa.mars.hover.domain.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * Boot
 *
 * Since this application it's a test scenario, non NASA official application,
 * we call this whole application as a Game Theory based application.
 *
 * Note.: This class is used to Manage all main Entities and components of
 * this application.
 *
 * @author @sant0ro
 * @version 1.0
 */
@SpringBootApplication
public class Boot {

    /**
     * Our set of Actors (Entities) of this application,
     * we can have multiple Hovers.
     */
    private Vector<Hover> hovers;

    /**
     * Ou set of Maps of this Game, since we can have many Maps
     * inside Mars.
     */
    private Vector<Map> maps;

    /**
     * Logger Instance, used to Log messages in the application
     */
    public final Logger logger;

    /**
     * Called by Spring Boot
     *
     * Creates Spring Boot environment and creates
     *  itself as an Singleton
     *
     * @param args Unused on this application
     */
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);

        new Boot(LoggerFactory.getLogger("Mars"));
    }

    /**
     * Create a new Instance of the Game Engine
     *
     * @param l Logger instance injected
     */
    private Boot(Logger l) {
        this.logger = l;

        // Instantiate our Classes
        this.hovers = new Vector<>();
        this.maps = new Vector<>();
    }

    /**
     * This Autowired Constructor should not be called.
     *
     * @throws RuntimeException We cannot use this, since we inject dependencies
     */
    private Boot() throws RuntimeException {
        throw new RuntimeException("This should not be called.");
    }

    /**
     * Add's a new Hover to he Game
     *
     * @param h Hover to be added
     * @return The added Hover
     */
    public Hover addHover(Hover h) {
        hovers.add(h);

        return h;
    }

    /**
     * Add's a new Hover to he Game
     *
     * @param name The name of the Hover
     * @return The added Hover
     */
    public Hover addHover(String name) {
        Hover h = new Hover(name);

        return addHover(h);
    }

    /**
     * Tries to get an Hover by the Hover name
     *
     * @param name Hover name
     */
    public Hover getHover(String name) {
        return hovers.stream().filter(h -> h.name.equals(name)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Get a List of Hovers based on their Current definition of Map
     *
     * @param map The Map instance
     * @return Return a List of Hovers
     */
    public List<Hover> getHovers(Map map) {
        return hovers.stream().filter(h -> h.map.equals(map)).collect(Collectors.toList());
    }

    /**
     * Get a List of Hovers based on their Current definition of Map
     *
     * @param name Map name
     * @return Return a List of Hovers
     */
    public List<Hover> getHovers(String name) {
        return getHovers(getMap(name));
    }

    /**
     * Add a new Map in the Game
     *
     * @param m The desired Map to be added
     * @return The added Map
     */
    public Map addMap(Map m) {
        maps.add(m);

        return m;
    }

    /**
     * Add a new Map in the Game
     *
     * @param name Map name
     * @param xBounds Map length/height
     * @param yBounds Map width
     * @return The added Map
     */
    public Map addMap(String name, int xBounds, int yBounds) {
        return addMap(new Map(name, xBounds, yBounds));
    }

    /**
     * Get a Map by the Name
     *
     * @param name Map name
     */
    public Map getMap(String name) {
        return maps.stream().filter(m -> m.name.equals(name)).findFirst().orElseThrow(NoSuchElementException::new);
    }

    /**
     * Remove a Map from the Game
     *  And removes all Hovers from the designed Map
     *
     * @param name Name of the Map
     */
    public boolean removeMap(String name) {
        return removeMap(getMap(name));
    }

    /**
     * Remove a Map from the Game
     *  And removes all Hovers from the designed Map
     *
     * @param m A map
     */
    public boolean removeMap(Map m) {
        getHovers(m).forEach(m::removeHover);

        return maps.remove(m);
    }

    /**
     * Remove a Hover from the Game
     *
     * @param name Hover name
     */
    public boolean removeHover(String name) {
        return removeHover(getHover(name));
    }

    /**
     * Remove a Hover from the Game
     *
     * @param h Hover Instance
     */
    public boolean removeHover(Hover h) {
        return hovers.remove(h);
    }
}

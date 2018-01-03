package nasa.mars.hover;

import nasa.mars.hover.domain.Hover;
import nasa.mars.hover.domain.Map;

import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;

/**
 * Game Manager
 * <p>
 * Since this application it's a test scenario, non NASA official application,
 * we call this whole application as a Game Theory based application.
 * <p>
 * Note.: This class is used to Manage all main Entities and components of
 * this application.
 *
 * @author @sant0ro
 * @version 1.0
 */
public class Game {

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
     * Create a new Instance of the Game Engine
     */
    public Game() {
        // Instantiate our Classes
        this.hovers = new Vector<>();
        this.maps = new Vector<>();

        // Create our default Hover
        this.addHover("Default Hover");

        // Create our default Map
        this.addMap("Mars", 5, 5);
    }

    /**
     * Tries to add a new Hover in the Game
     *
     * @param h The desired Hover to be added
     */
    public void addHover(Hover h) {
        if(this.getHover(h.id) != null) {
            System.out.println("The Game cannot have the same Hover twice.");

            return;
        }

        this.hovers.add(h);
    }

    /**
     * Add's a new Hover to he Game
     *
     * @param name The name of the Hover
     */
    public void addHover(String name) {
        Hover h = new Hover(this.hovers.size() + 1, name);

        this.hovers.add(h);
    }

    /**
     * Tries to get an Hover by the Hover Unique Identifier
     *
     * @param id Hover unique Identifier
     */
    public Hover getHover(int id) {
        return this.hovers.stream().filter(h -> h.id == id).findFirst().orElse(null);
    }

    /**
     * Tries to get an Hover by the Hover name
     *
     * @param name Hover name
     */
    public Hover getHover(String name) {
        return this.hovers.stream().filter(h -> h.name.equals(name)).findFirst().orElse(null);
    }

    /**
     * Get a List of Hovers based on their Current definition of Map
     *
     * @param map The Map instance
     * @return Return a List of Hovers
     */
    public List<Hover> getHovers(Map map) {
        return this.hovers.stream().filter(h -> h.getCurrentMap().name.equals(map.name)).collect(Collectors.toList());
    }

    /**
     * Get a List of Hovers based on their Current definition of Map
     *
     * @param name The Map name
     * @return Return a List of Hovers
     */
    public List<Hover> getHovers(String name) {
        return this.hovers.stream().filter(h -> h.getCurrentMap() != null && h.getCurrentMap().name.equals(name)).collect(Collectors.toList());
    }

    /**
     * Add a new Map in the Game
     *
     * @param m The desired Map to be added
     */
    public void addMap(Map m) {
        this.maps.add(m);
    }

    /**
     * Add a new Map in the Game
     *
     * @param name The name of the Map
     * @param xBounds The length of the Map
     * @param yBounds The width of the Map
     */
    public void addMap(String name, int xBounds, int yBounds) {
        this.addMap(new Map(name, xBounds, yBounds));
    }

    /**
     * Tries to recover a Map by the Map name
     *
     * @param name Map name
     */
    public Map getMap(String name) {
        return this.maps.stream().filter(h -> h.name.equals(name)).findFirst().orElse(null);
    }

    /**
     * Remove a Map from the Game, and removes all Hovers from the designed Map
     *
     * @param name The Map name
     */
    public void removeMap(String name) {
        Map temporary = this.getMap(name);

        if(temporary == null)
            return;

        this.getHovers(temporary).forEach(h -> temporary.removeHover(h.id));

        this.maps.remove(temporary);
    }

    /**
     * Remove a Hover from the Game by its Name
     *
     * @param name the Hover Name
     */
    public void removeHover(String name) {
        Hover temporary = this.getHover(name);

        if(temporary == null)
            return;

        this.hovers.remove(temporary);
    }

    /**
     * Remove a Hover from the Game by its Unique Identifier
     *
     * @param id Hover Id
     */
    public void removeHover(int id) {
        Hover temporary = this.getHover(id);

        if(temporary == null)
            return;

        this.hovers.remove(temporary);
    }
}

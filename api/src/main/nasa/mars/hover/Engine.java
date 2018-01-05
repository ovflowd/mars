package nasa.mars.hover;

import nasa.mars.hover.service.composite.HoverRepository;
import nasa.mars.hover.service.composite.MapRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Engine Facade
 *
 * The Engine behind the Application
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@Service
public class Engine {

    /**
     * The Map Repository
     */
    @Autowired
    private MapRepository maps;

    /**
     * The Hover Repository
     */
    @Autowired
    private HoverRepository hovers;

    /**
     * Creates a new Instance of the Engine Facade
     *
     * @param maps The Map Repository
     * @param hovers The Hover Repository
     */
    public Engine(MapRepository maps, HoverRepository hovers) {
        this.maps = maps;
        this.hovers = hovers;
    }

    /**
     * Get the Map Repository Instance
     *
     * @return Repository Instance
     */
    public MapRepository getMaps() {
        return maps;
    }

    /**
     * Get the Hover Repository Instance
     *
     * @return Repository Instance
     */
    public HoverRepository getHovers() {
        return hovers;
    }
}

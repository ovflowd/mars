package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Earth Map Builder
 *
 * Used to build Earth Map
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@Service
@Scope("prototype")
public class EarthMapBuilder extends MapBuilder {

    /**
     * Creates a new Earth Map
     *
     * @param map autowired map
     */
    public EarthMapBuilder(Map map) {
        this.map = map;
    }

    /**
     * Build the Height of te Map
     */
    @Override
    public void buildHeight() {
        this.map.height = 3;
    }

    /**
     * Build the Width of the Map
     */
    @Override
    public void buildWidth() {
        this.map.width = 3;
    }

    /**
     * Build the Name of the Map
     */
    @Override
    public void buildName() {
        this.map.name = "Earth";
    }
}

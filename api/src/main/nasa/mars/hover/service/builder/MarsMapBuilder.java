package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Map;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * Mars Map Builder
 * <p>
 * Used to build Mars Map
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
@Service
@Scope("prototype")
public class MarsMapBuilder extends MapBuilder {

    /**
     * Creates a new Mars Map
     *
     * @param map autowired map
     */
    public MarsMapBuilder(Map map) {
        this.map = map;
    }

    /**
     * Build the Height of te Map
     */
    @Override
    public void buildHeight() {
        this.map.height = 5;
    }

    /**
     * Build the Width of the Map
     */
    @Override
    public void buildWidth() {
        this.map.width = 5;
    }

    /**
     * Build the Name of the Map
     */
    @Override
    public void buildName() {
        this.map.name = "Mars";
    }
}

package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Map;
import nasa.mars.hover.service.IBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Map Builder
 * <p>
 * Used to build specific Maps
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
public abstract class MapBuilder implements IBuilder<Map> {

    /**
     * The Hover Instance linked to the Builder
     */
    @Autowired
    protected Map map;

    /**
     * Build the Height of te Map
     */
    abstract void buildHeight();

    /**
     * Build the Width of the Map
     */
    abstract void buildWidth();

    /**
     * Build the Name of the Map
     */
    abstract void buildName();

    /**
     * Get the result Map
     *
     * @return Map Instance
     */
    @Override
    public Map build() {
        buildName();
        buildHeight();
        buildWidth();

        return map;
    }
}

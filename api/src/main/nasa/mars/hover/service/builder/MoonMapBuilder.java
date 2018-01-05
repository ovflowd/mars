package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Moon Map Builder
 *
 * Used to build Moon Map
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@Service
public class MoonMapBuilder extends MapBuilder {

    /**
     * The Map Instance linked to the Builder
     */
    @Autowired
    private Map map;

    /**
     * Build the Height of te Map
     */
    @Override
    public void buildHeight() {
        this.map.height = 2;
    }

    /**
     * Build the Width of the Map
     */
    @Override
    public void buildWidth() {
        this.map.width = 2;
    }

    /**
     * Build the Name of the Map
     */
    @Override
    public void buildName() {
        this.map.name = "Moon";
    }

    /**
     * Get the result Map
     *
     * @return Map Instance
     */
    @Override
    public Map build(){
        buildName();
        buildHeight();
        buildWidth();

        return map;
    }
}

package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Hover;
import nasa.mars.hover.service.IBuilder;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Hover Builder
 *
 * Used to build specific Maps
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
public abstract class HoverBuilder implements IBuilder<Hover> {

    /**
     * The Hover Instance linked to the Builder
     */
    @Autowired
    protected Hover hover;

    /**
     * Build the Name of the Hover
     */
    abstract void buildName();

    /**
     * Build the Launch Date of the Hover
     */
    abstract void buildLaunchDate();

    /**
     * Build the Mission Status of the Hover
     */
    abstract void buildMissionStatus();

    /**
     * Get the result Hover
     *
     * @return Hover Instance
     */
    @Override
    public Hover build(){
        buildName();
        buildLaunchDate();
        buildMissionStatus();

        return hover;
    }
}

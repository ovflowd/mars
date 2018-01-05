package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Hover;
import nasa.mars.hover.service.IBuilder;

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
    public abstract Hover build();
}

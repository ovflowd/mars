package nasa.mars.hover.service.builder;

import nasa.mars.hover.model.Hover;
import nasa.mars.hover.model.enumerator.Mission;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * NASA's Curiosity Hover Builder
 *
 * Used to build Earth Map
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@Service
@Scope("prototype")
public class CuriosityHoverBuilder extends HoverBuilder {

    /**
     * Creates a new Curiosity Hover
     *
     * @param hover autowired hover
     */
    public CuriosityHoverBuilder(Hover hover) {
        this.hover = hover;
    }

    /**
     * Build the Name of the Hover
     */
    @Override
    public void buildName() {
        hover.name = "Curiosity";
    }

    /**
     * Build the Launch Date of the Hover
     */
    @Override
    void buildLaunchDate() {
        hover.launch = new Date(2011, 11, 26);
    }

    /**
     * Build the Mission Status of the Hover
     */
    @Override
    void buildMissionStatus() {
        hover.status = Mission.OPERATING;
    }
}

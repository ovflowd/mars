package nasa.mars.hover.unit;

import nasa.mars.hover.Engine;
import nasa.mars.hover.model.Hover;
import nasa.mars.hover.model.enumerator.Mission;
import nasa.mars.hover.service.builder.CuriosityHoverBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Hover Test
 *
 * Unit Test that realizes many assertions with
 *  the Hover Entity
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class HoverTest {

    @Autowired
    private Engine engine;

    @Autowired
    private CuriosityHoverBuilder curiosityHoverBuilder;

    @Test
    @DisplayName("Tries to create and manipulate Hovers")
    void testHover() {
        // Test if by default the Repository it's empty
        assertEquals(false, engine.getHovers().exists("Land Rover"));

        // Test if Building a Hover inside a repository, goes well.
        assertNotNull(engine.getHovers().build(curiosityHoverBuilder));

        // Test if the Built Hover it's really stored on the Repository
        assertNotNull(engine.getHovers().get("Curiosity"));

        // Test if removing a Hover by the name, results in actually removing it.
        assertEquals(true, engine.getHovers().remove("Curiosity"));

        // Check if creating a Hover manually without a Factory or a Builder works.
        assertNotNull(new Hover("Loyal Hover", new Date(), Mission.FAILURE).coordinate());

        // Clear everything.
        engine.getHovers().clear();

        // Check if after clearing it, we don't have any element.
        assertEquals(0, engine.getHovers().all().size());
    }
}

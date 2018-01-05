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
 * Does tests with the Hovers
 *
 * @author @sant0ro
 * @version 1.1
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

        // Test if added with success it on the repository
        assertNotNull(engine.getHovers().build(curiosityHoverBuilder));

        // Test if really it's stored on teh repository
        assertNotNull(engine.getHovers().get("Curiosity"));

        // Test if removing goes well
        assertEquals(true, engine.getHovers().remove("Curiosity"));

        // Check if creating manually Hovers, Coordinate goes well
        assertNotNull(new Hover("Loyal Hover", new Date(), Mission.FAILURE).coordinate());
    }
}

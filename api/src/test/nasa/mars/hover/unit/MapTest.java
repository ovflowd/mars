package nasa.mars.hover.unit;

import nasa.mars.hover.Engine;
import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.Hover;
import nasa.mars.hover.model.Map;
import nasa.mars.hover.model.enumerator.Cardinal;
import nasa.mars.hover.service.builder.EarthMapBuilder;
import nasa.mars.hover.service.builder.MoonMapBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Map Test
 *
 * Test Creating Maps and Manipulating It
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class MapTest {

    @Autowired
    private Engine engine;

    @Autowired
    private MoonMapBuilder moonMapBuilder;

    @Autowired
    private EarthMapBuilder earthMapBuilder;

    @Test
    @DisplayName("Tries to create Maps and check the valid Paths")
    void testMapBounds() {
        Map moonMap = engine.getMaps().build(moonMapBuilder);

        assertEquals(false, moonMap.valid(33, 33));

        assertEquals(true, moonMap.valid(1, 1));

        assertEquals(false, moonMap.valid(-20, 0));

        Map earthMap = engine.getMaps().build(earthMapBuilder);

        assertEquals(true, earthMap.valid(2, 2));

        assertEquals(false, earthMap.valid(90, 3));
    }

    @Test
    @DisplayName("Add Hover to a Map and test with it")
    void testPathFinder() {
        Map earthMap = engine.getMaps().build(earthMapBuilder);

        Hover landHover = engine.getHovers().add(new Hover("Land Hover"));

        Hover spaceXHover = engine.getHovers().add(new Hover("SpaceX Hover"));

        // First we land our Land Hover
        earthMap.link(landHover);

        // Check if we can move the Hover on a valid place of the Map
        assertEquals(true, earthMap.move(landHover, new Coordinate(1, 1, Cardinal.EAST)));

        // Now we land our SpaceX hover
        earthMap.link(spaceXHover);

        // Should not move, since we already have our Lander Hover here.
        assertEquals(false, earthMap.move(spaceXHover, new Coordinate(1, 1, Cardinal.EAST)));

        // Should move, test if recover correctly the Hover by the Name
        assertEquals(true, earthMap.move("SpaceX Hover", new Coordinate(2, 2, Cardinal.EAST)));

        // Mission ended for Land Hover
        earthMap.unlink("Land Hover");

        // Now it should move.
        assertEquals(true, earthMap.move(spaceXHover, new Coordinate(1, 1, Cardinal.EAST)));
    }

    @Test
    @DisplayName("Tries to create and manipulate Maps")
    void testMap() {
        // Test if by default the Repository it's empty
        assertEquals(false, engine.getMaps().exists("A Beautiful Map"));

        // Test if added with success it on the repository
        assertNotNull(engine.getMaps().build(moonMapBuilder));

        // Test if really it's stored on teh repository
        assertNotNull(engine.getMaps().get("Moon"));

        // Test if removing goes well
        assertEquals(true, engine.getMaps().remove("Moon"));

        // Clear everything.
        engine.getMaps().clear();

        // Now we should have nothing
        assertEquals(0, engine.getMaps().all().size());
    }
}

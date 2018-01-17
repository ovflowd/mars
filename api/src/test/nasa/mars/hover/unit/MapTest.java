package nasa.mars.hover.unit;

import nasa.mars.hover.Engine;
import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.Hover;
import nasa.mars.hover.model.Map;
import nasa.mars.hover.model.enumerator.Cardinal;
import nasa.mars.hover.model.enumerator.Mission;
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

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * Map Test
 *
 * Unit Test and Functional Test for all behaviours that
 *  the Map Component could do.
 *
 * @author @sant0ro
 * @version 1.2
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
        // Build a new Moon Map and add it to the Map Repository
        Map moonMap = engine.getMaps().build(moonMapBuilder);

        // (33, 33) is an invalid point in the Map, because it's out of the Bounds
        // That assertion should return false, because that point is invalid.
        assertEquals(false, moonMap.valid(33, 33));

        // This is a valid Point, the bounds of a Moon Map are (2, 2)
        assertEquals(true, moonMap.valid(1, 1));

        // We can't either have negative Points, that doesn't exists in a 2D Map
        // Only exists in a 3D map, where the angle it's the Z angle.
        assertEquals(false, moonMap.valid(-20, 0));

        // Build a new Earth Map and add it to the Map Repository
        Map earthMap = engine.getMaps().build(earthMapBuilder);

        // This should return true, it's a valid Point, the Bounds are (3, 3);
        assertEquals(true, earthMap.valid(2, 2));

        // This is an invalid Point in the Map, exceeds the Bounds.
        assertEquals(false, earthMap.valid(90, 3));
    }

    @Test
    @DisplayName("Add Hover to a Map and test with it")
    void testPathFinder() {
        // Build a new Earth Map and add it to the Map Repository
        Map earthMap = engine.getMaps().build(earthMapBuilder);

        // Add a new Hover called "Land Hover"
        Hover landHover = engine.getHovers().add(new Hover("Land Hover"));

        // Add a new Hover called "SpaceX Hover" (Our Dream...(
        Hover spaceXHover = engine.getHovers().add(new Hover("SpaceX Hover"));

        // First we land our Land Hover to the Map
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

        engine.getHovers().add(new Hover("Hello Darkness my Old friend", new Date(), Mission.FAILURE));

        // Check if linking by Name works
        engine.getMaps().get("Moon").link("Hello Darkness my Old friend");

        // Tries to Unlink an non existent Hover, by Object
        assertEquals(false, engine.getMaps().get("Moon").unlink((Hover) null));

        // Tries to Unlink an non existent Hover, by Name
        assertEquals(false, engine.getMaps().get("Moon").unlink("Lazy Hover"));

        // Test if removing goes well
        assertEquals(true, engine.getMaps().remove("Moon"));

        // Clear everything.
        engine.getMaps().clear();

        // Now we should have nothing
        assertEquals(0, engine.getMaps().all().size());
    }
}

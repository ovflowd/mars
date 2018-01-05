package nasa.mars.hover.unit;

import nasa.mars.hover.Boot;
import nasa.mars.hover.domain.Map;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MapTest
 *
 * Test Creating Maps and Manipulating It
 *
 * @author @sant0ro
 * @version 1.0
 */
class MapTest {

    @Before
    void setUp() {
        new Boot();
    }

    @Test
    @DisplayName("Check if the Default Map exists")
    void testExists() {
        assertEquals("Mars", Boot.getGame().getMap("Mars").name);
    }

    @Test
    @DisplayName("Tries to create Maps and Iterate with it")
    void testPathFinder() {
        Map secondMap = new Map("Moon", 5, 5);

        assertEquals(false, secondMap.getPathFinder().checkPath(33, 33));

        assertEquals(true, secondMap.getPathFinder().checkPath(4, 1));

        assertEquals(false, secondMap.getPathFinder().checkPath(-20, 0));
    }
}

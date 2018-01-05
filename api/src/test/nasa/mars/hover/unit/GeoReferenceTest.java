package nasa.mars.hover.unit;

import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.enumerator.Cardinal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * GeoReferenceTest
 *
 * Unit Test for testing expected outputs from GeoReference Enumerator
 *
 * @author @sant0ro
 * @version 1.0
 */
@RunWith(JUnitPlatform.class)
@SpringBootTest()
class GeoReferenceTest {

    @Autowired
    private Coordinate coordinate;

    @Test
    @DisplayName("Check if all characters return in their respective Coordinate Headings")
    void testCardinal() {
        coordinate.heading = Cardinal.NORTH;

        assertEquals('N', coordinate.heading.getCode());

        coordinate.heading = Cardinal.EAST;

        assertEquals('E', coordinate.heading.getCode());

        coordinate.heading = Cardinal.WEST;

        assertEquals('W', coordinate.heading.getCode());

        coordinate.heading = Cardinal.SOUTH;

        assertEquals('S', coordinate.heading.getCode());
    }

    @Test
    @DisplayName("Check the value of each Heading")
    void testAngles() {
        assertEquals(90, Cardinal.NORTH.getAngle());

        assertEquals(270, Cardinal.SOUTH.getAngle());

        assertEquals(0, Cardinal.EAST.getAngle());

        assertEquals(180, Cardinal.WEST.getAngle());
    }
}

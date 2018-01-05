package nasa.mars.hover.unit;

import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.GeoReference;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * GeoReferenceTest
 *
 * Unit Test for testing expected outputs from GeoReference Enumerator
 *
 * @author @sant0ro
 * @version 1.0
 */
class GeoReferenceTest {

    @Test
    @DisplayName("Check if all characters return in their respective Coordinate Headings")
    void testCoordinate() {
        Coordinate c;

        c = new Coordinate(0, 0, GeoReference.NORTH);

        assertEquals('N', GeoReference.headingCode(c));

        c = new Coordinate(0, 0, GeoReference.EAST);

        assertEquals('E', GeoReference.headingCode(c));

        c = new Coordinate(0, 0, GeoReference.WEST);

        assertEquals('W', GeoReference.headingCode(c));

        c = new Coordinate(0, 0, GeoReference.SOUTH);

        assertEquals('S', GeoReference.headingCode(c));
    }

    @Test
    @DisplayName("Check the value of each Heading")
    void testDegrees() {
        assertEquals(90, GeoReference.NORTH);

        assertEquals(270, GeoReference.SOUTH);

        assertEquals(0, GeoReference.EAST);

        assertEquals(180, GeoReference.WEST);
    }
}

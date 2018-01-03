package nasa.mars.hover.unit;

import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.GeoReference;
import nasa.mars.hover.util.Interpreter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * InerpreterTest
 *
 * Check if the Interpreter goes well
 *
 * @author @sant0ro
 * @version 1.0
 */
class InterpreterTest {

    @Test
    @DisplayName("Check if Interpreter creates correct Coordinates")
    void testCoordinates() {
        assertEquals(null, Interpreter.translate("MARLL"));

        assertEquals(new Coordinate(0, 2, GeoReference.NORTH).position.y, Interpreter.translate("MM").position.y);

        assertEquals(new Coordinate(2, 2, GeoReference.EAST).heading, Interpreter.translate("MMRMM").heading);
    }
}

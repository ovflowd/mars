package nasa.mars.hover.unit;

import nasa.mars.hover.aspect.interpreter.MartianInterpreter;
import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.enumerator.Cardinal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Inerpreter Test
 *
 * Check if the Interpreter goes well
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class InterpreterTest {

    @Autowired
    private MartianInterpreter interpreter;

    @Autowired
    private Coordinate coordinate;

    @Test
    @DisplayName("Check if Interpreter creates correct Coordinates")
    void testCoordinates() {
        assertThrows(RuntimeException.class, ()-> interpreter.translate("MARLL"));

        assertEquals(coordinate.update(0, 2, Cardinal.NORTH), interpreter.translate("MM"));

        assertEquals(coordinate.update(2, 2, Cardinal.EAST), interpreter.translate("MMRMM"));
    }
}

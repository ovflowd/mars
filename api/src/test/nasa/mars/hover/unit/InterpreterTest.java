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
 * Interpreter Test
 *
 * Unit Test to checks the behaviour
 *  of the Command Interpreter
 *
 * @author @sant0ro
 * @version 1.2
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
        // Should throw an exception, invalid command inside the command dictionary
        assertThrows(RuntimeException.class, ()-> interpreter.translate("MARLL"));

        // Testing dictionary -> move, move
        assertEquals(coordinate.update(0, 2, Cardinal.NORTH), interpreter.translate("MM"));

        // Testing dictionary -> move, move, right, move, move
        assertEquals(coordinate.update(2, 2, Cardinal.EAST), interpreter.translate("MMRMM"));

        // Testing dictionary -> move, move, right, left, move
        assertEquals(coordinate.update(0, 3, Cardinal.NORTH), interpreter.translate("MMRLM"));

        // Testing dictionary -> left, left, left, left, right, right, right, right
        assertEquals(coordinate.update(0, 0, Cardinal.NORTH), interpreter.translate("LLLLRRRR"));

        // Testing dictionary -> right, move, left, left, move
        assertEquals(coordinate.update(0, 0, Cardinal.NORTH), interpreter.translate("RMLLM"));
    }
}

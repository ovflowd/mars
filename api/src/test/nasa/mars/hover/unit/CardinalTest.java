package nasa.mars.hover.unit;

import nasa.mars.hover.model.enumerator.Cardinal;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * Cardinal Test
 *
 * Unit Test for asserting the behaviour of the
 *  Cardinal Enumerator
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class CardinalTest {

    @Test
    @DisplayName("Test recovering values of Cardinal")
    void testCardinal() {
        // Should throw an exception because isn't a valid angle in a 90 division base.
        assertThrows(RuntimeException.class, ()-> Cardinal.byAngle(56));

        // Should return null, because 360 isn't an angle that belongs to the Enumerator.
        // For the 36º angle, use 0º
        assertNull(Cardinal.byAngle(360));

        // Check if using the accessor "byAngle" of 0º actually returns the right Cardinal.
        assertEquals(Cardinal.EAST, Cardinal.byAngle(0));

        // Check if using the accessor "byAngle" of 90º actually returns the right Cardinal.
        assertEquals(Cardinal.NORTH, Cardinal.byAngle(90));

        // Check if using the accessor "byAngle" of 180º actually returns the right Cardinal.
        assertEquals(Cardinal.WEST, Cardinal.byAngle(180));

        // Check if using the accessor "byAngle" of 270º actually returns the right Cardinal.
        assertEquals(Cardinal.SOUTH, Cardinal.byAngle(270));
    }
}

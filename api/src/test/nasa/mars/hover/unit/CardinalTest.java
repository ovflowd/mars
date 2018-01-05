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
 * Unit Test fro the Cardinal Enumerator
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class CardinalTest {

    @Test
    @DisplayName("Test recovering values of Cardinal")
    void testCardinal() {
        // Should throw exception, isn't a valid Cardinal.
        assertThrows(RuntimeException.class, ()-> Cardinal.valueOf(56));

        // Should return null, we don't have a 360 cardinal stored on our map.
        assertNull(Cardinal.valueOf(360));

        // Should be true
        assertEquals(Cardinal.NORTH, Cardinal.valueOf(90));

        // Should be true
        assertEquals(Cardinal.SOUTH, Cardinal.valueOf(270));

        // Should be true
        assertEquals(Cardinal.EAST, Cardinal.valueOf(0));

        // Should be true
        assertEquals(Cardinal.WEST, Cardinal.valueOf(180));
    }
}

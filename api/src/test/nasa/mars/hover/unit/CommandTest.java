package nasa.mars.hover.unit;

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

/**
 * Command Test
 *
 * Unit Test fro the Command Iterator
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class CommandTest {

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

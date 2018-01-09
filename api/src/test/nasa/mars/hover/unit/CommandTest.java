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
 * @version 1.2
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

        // Check if the Letter Code of North is correct
        assertEquals('N', coordinate.heading.getCode());

        coordinate.heading = Cardinal.EAST;

        // Check if the Letter Code of East is correct
        assertEquals('E', coordinate.heading.getCode());

        coordinate.heading = Cardinal.WEST;

        // Check if the Letter Code of West is correct
        assertEquals('W', coordinate.heading.getCode());

        coordinate.heading = Cardinal.SOUTH;

        // Check if the Letter Code of South is correct
        assertEquals('S', coordinate.heading.getCode());
    }

    @Test
    @DisplayName("Check the value of each Heading")
    void testAngles() {
        coordinate.heading = Cardinal.NORTH;

        // Check if the Angle in Degrees of North is correct
        assertEquals(90, coordinate.heading.getAngle());

        coordinate.heading = Cardinal.SOUTH;

        // Check if the Angle in Degrees of South is correct
        assertEquals(270, coordinate.heading.getAngle());

        coordinate.heading = Cardinal.EAST;

        // Check if the Angle in Degrees of East is correct
        assertEquals(0, coordinate.heading.getAngle());

        coordinate.heading = Cardinal.WEST;

        // Check if the Angle in Degrees of West is correct
        assertEquals(180, coordinate.heading.getAngle());
    }
}

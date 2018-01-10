package nasa.mars.hover.unit;

import nasa.mars.hover.aspect.dictionary.LeftCommand;
import nasa.mars.hover.aspect.dictionary.MoveCommand;
import nasa.mars.hover.aspect.dictionary.RightCommand;
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

import java.awt.*;

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

    @Test
    @DisplayName("Check if the Right Command works Well")
    void testRightCommand() {
        coordinate.heading = Cardinal.NORTH;

        // Test if the Command reduces -90 in the Heading. (Now be 0, EAST)
        assertEquals(Cardinal.EAST, (new RightCommand()).coordinate(coordinate).execute());

        // Test if the Command reduces -90 in the Heading. (Now be 270, SOUTH)
        assertEquals(Cardinal.SOUTH, (new RightCommand()).coordinate(coordinate).execute());

        // Test if the Command reduces -90 in the Heading. (Now be 180, WEST)
        assertEquals(Cardinal.WEST, (new RightCommand()).coordinate(coordinate).execute());

        // Test if the Command reduces -90 in the Heading. (Now be 90, NORTH)
        assertEquals(Cardinal.NORTH, (new RightCommand()).coordinate(coordinate).execute());
    }

    @Test
    @DisplayName("Check if the Left Command works Well")
    void testLeftCommand() {
        coordinate.heading = Cardinal.NORTH;

        // Test if the Command increases +90 in the Heading. (Now be 180, WEST)
        assertEquals(Cardinal.WEST, (new LeftCommand()).coordinate(coordinate).execute());

        // Test if the Command increases +90 in the Heading. (Now be 270, SOUTH)
        assertEquals(Cardinal.SOUTH, (new LeftCommand()).coordinate(coordinate).execute());

        // Test if the Command increases +90 in the Heading. (Now be 0, EAST)
        assertEquals(Cardinal.EAST, (new LeftCommand()).coordinate(coordinate).execute());

        // Test if the Command increases +90 in the Heading. (Now be 90, NORTH)
        assertEquals(Cardinal.NORTH, (new LeftCommand()).coordinate(coordinate).execute());
    }

    @Test
    @DisplayName("Check if the Move Command works Well")
    void testMoveCommand() {
        coordinate.update(0, 0, Cardinal.NORTH);

        // Going to North, need be Y+1
        assertEquals(new Point(0, 1), (new MoveCommand()).coordinate(coordinate).execute());

        coordinate.heading = Cardinal.EAST;

        // Going to East, need be X+1
        assertEquals(new Point(1, 1), (new MoveCommand()).coordinate(coordinate).execute());
    }
}

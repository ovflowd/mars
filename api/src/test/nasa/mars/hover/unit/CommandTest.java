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
 * Unit Test for asserting multiple different scenarios
 *  involving Commands, that includes Coordinates, Cardinals
 *  and other Entities/Components.
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
    void testLetters() {
        // Setting the Heading to North
        coordinate.heading = Cardinal.NORTH;

        // Checking if returning the North Cardinal, actually gives us the North Letter
        assertEquals('N', coordinate.heading.getCode());

        // Setting the Heading to East
        coordinate.heading = Cardinal.EAST;

        // Checking if returning the East Cardinal, actually gives us the East Letter
        assertEquals('E', coordinate.heading.getCode());

        // Setting the Heading to West
        coordinate.heading = Cardinal.WEST;

        // Checking if returning the West Cardinal, actually gives us the West Letter
        assertEquals('W', coordinate.heading.getCode());

        // Setting the Heading to South
        coordinate.heading = Cardinal.SOUTH;

        // Checking if returning the South Cardinal, actually gives us the South Letter
        assertEquals('S', coordinate.heading.getCode());
    }

    @Test
    @DisplayName("Check the value of each Heading")
    void testAngles() {
        // Setting the Heading to North
        coordinate.heading = Cardinal.NORTH;

        // Checking if returning the North Cardinal, actually gives us the North Angle
        assertEquals(90, coordinate.heading.getAngle());

        // Setting the Heading to South
        coordinate.heading = Cardinal.SOUTH;

        // Checking if returning the South Cardinal, actually gives us the South Angle
        assertEquals(270, coordinate.heading.getAngle());

        // Setting the Heading to East
        coordinate.heading = Cardinal.EAST;

        // Checking if returning the East Cardinal, actually gives us the East Angle
        assertEquals(0, coordinate.heading.getAngle());

        // Setting the Heading to West
        coordinate.heading = Cardinal.WEST;

        // Checking if returning the West Cardinal, actually gives us the West Angle
        assertEquals(180, coordinate.heading.getAngle());
    }

    @Test
    @DisplayName("Check if the Right Command works Well")
    void testRightCommand() {
        // Setting the Heading to North (Resetting)
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
        // Setting the Heading to North (Resetting)
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
        // Changing the Position to the Initial Map Position
        coordinate.update(0, 0, Cardinal.NORTH);

        // Going to North, need be Y+1
        assertEquals(new Point(0, 1), (new MoveCommand()).coordinate(coordinate).execute());

        // Just randomly updating the Heading to East
        coordinate.heading = Cardinal.EAST;

        // Going to East, need be X+1
        assertEquals(new Point(1, 1), (new MoveCommand()).coordinate(coordinate).execute());
    }
}

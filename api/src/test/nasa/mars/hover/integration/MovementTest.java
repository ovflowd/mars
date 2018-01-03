package nasa.mars.hover.integration;

import nasa.mars.hover.Game;
import nasa.mars.hover.controllers.Movement;
import org.junit.Before;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MovementTest
 *
 * Integration Test for the Controller Movement
 * @version 1.0
 * @author @sant0ro
 */
@RunWith(JUnitPlatform.class)
@WebAppConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovementTest {

    @Before
    void setUp() {
        new Game();
    }

    private Movement movement = new Movement();

    @Test
    @DisplayName("Checking if the command 'MMRMMRMM' works")
    void testFirstCommand() {
        assertEquals("(2, 0, S)", movement.getCoordinate("MMRMMRMM").getBody());
    }

    @Test
    @DisplayName("Checking if the command 'MML' works")
    void testSecondCommand() {
        assertEquals("(0, 2, W)", movement.getCoordinate("MML").getBody());
    }

    @Test
    @DisplayName("Checking if an invalid command doesn't works")
    void testFirstInvalidCommand() {
        assertEquals("400 Bad Request", movement.getCoordinate("AAA").getBody());
    }

    @Test
    @DisplayName("Checking if an invalid command doesn't works")
    void testSecondInvalidCommand() {
        assertEquals("400 Bad Request", movement.getCoordinate("MMMMMMMMMMMMMMMMMMMMMMMM").getBody());
    }
}

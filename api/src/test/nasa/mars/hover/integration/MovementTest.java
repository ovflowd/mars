package nasa.mars.hover.integration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

/**
 * MovementTest
 *
 * Integration Test for testing o the Movement Controller
 *  does operate in the specified way from the challenge.
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.0
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
class MovementTest {

    @Autowired
    TestRestTemplate restTemplate;

    @Test
    @DisplayName("Check if the Command 'MMRMMRMM' works and results in the right position on the map.")
    void testFirstCommand() {
        assertEquals("(2, 0, S)", restTemplate.postForEntity("/rest/mars/MMRMMRMM", null, String.class).getBody());
    }

    @Test
    @DisplayName("Check if the Command 'MML' works and results in the right position on the map.")
    void testSecondCommand() {
        assertEquals("(0, 2, W)", restTemplate.postForEntity("/rest/mars/MML", null, String.class).getBody());
    }

    @Test
    @DisplayName("Checking if an invalid command 'AAA' doesn't works.")
    void testFirstInvalidCommand() {
        assertEquals("400 Bad Request", restTemplate.postForEntity("/rest/mars/AAA", null, String.class).getBody());
    }

    @Test
    @DisplayName("Checking if a command 'MMMMMMMMMMMMMMMMMMMMMMMM' that bounds out of the map doesn't works.")
    void testSecondInvalidCommand() {
        assertEquals("400 Bad Request", restTemplate.postForEntity("/rest/mars/MMMMMMMMMMMMMMMMMMMMMMMM", null, String.class).getBody());
    }
}

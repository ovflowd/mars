package nasa.mars.hover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * A simple algorithm to trace routes to a NASA's Hover.
 *
 * @version 1.0
 * @author @sant0ro
 */
@SpringBootApplication
public class Boot {

    /**
     * Our Game Manager Instance
     */
    private static Game game = new Game();

    /**
     * Creates the SpringBoot Application Environment
     *
     * @param args CLI input parameters, not used on this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }

    /**
     * Get the Instance of the Game Manager
     *
     * @return Game instance
     */
    public static Game getGame() {
        return game;
    }
}

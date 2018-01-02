package nasa.mars.hover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Package nasa.mars.hover
 *
 * A simple algorithm to trace routes to a NASA's Hover.
 *
 * @Version 1.0
 * @Author @sant0ro
 */
@SpringBootApplication
public class Boot {

    /**
     * Creates the SpringBoot Application Environment
     *
     * @param args CLI input parameters, not used on this application.
     */
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}

package nasa.mars.hover;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Boot
 *
 * Since this application it's a test scenario, non NASA official application,
 * we call this whole application as a Game Theory based application.
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.0
 */
@SpringBootApplication
@ComponentScan("nasa.mars.hover")
public class Boot {

    /**
     * Called by Spring Boot
     *
     * Creates Spring Boot environment and creates
     *  itself as an Singleton
     *
     * @param args Unused on this application
     */
    public static void main(String[] args) {
        SpringApplication.run(Boot.class, args);
    }
}

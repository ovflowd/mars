package nasa.mars.hover.aspect.dictionary;

import nasa.mars.hover.model.Coordinate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.awt.*;

/**
 * Move Command
 *
 * Move Position Command
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.2
 * @see Coordinate
 */
@Component
public class MoveCommand extends AbstractCommand<Point> {

    /**
     * Get the current Heading and with it Moves the Coordinate instance
     *
     * @return A Point with the result of the Location
     */
    @Override
    public Point execute() {
        coordinate.setLocation(((Coordinate) coordinate.heading.getCommand().execute()).getLocation());

        return coordinate.getLocation();
    }

    /**
     * Get's the Code of the Command
     *
     * @return Letter Code of the Command
     */
    public char code() {
        return 'M';
    }
}

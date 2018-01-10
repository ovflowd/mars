package nasa.mars.hover.aspect.dictionary;

import nasa.mars.hover.model.enumerator.Cardinal;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Left Command
 * <p>
 * Change the Heading of a Coordinate to one level to
 * left, since each Heading has 90º of difference.
 *
 * @author @sant0ro
 * @version 1.2
 * @see nasa.mars.hover.model.Coordinate
 * @since 1.2
 */
@Component
@Qualifier("prototype")
public class LeftCommand extends AbstractCommand<Cardinal> {

    /**
     * Get the Current Heading and change the Heading to Left
     *
     * @return The resulted Cardinal
     */
    @Override
    public Cardinal execute() {
        return coordinate.heading = (coordinate.heading == Cardinal.SOUTH ? Cardinal.EAST :
                Cardinal.byAngle(coordinate.heading.getAngle() + 90));
    }

    /**
     * Get's the Code of the Command
     *
     * @return Letter Code of the Command
     */
    public char code() {
        return 'L';
    }
}

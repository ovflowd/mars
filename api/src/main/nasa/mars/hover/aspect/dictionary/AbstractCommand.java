package nasa.mars.hover.aspect.dictionary;

import nasa.mars.hover.aspect.Command;
import nasa.mars.hover.model.Coordinate;

/**
 * Abstract Command
 *
 * An Abstract Command
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.2
 * @see nasa.mars.hover.model.Coordinate
 */
public abstract class AbstractCommand<T> implements Command<T> {

    /**
     * Coordinate Point to be iterated
     */
    protected Coordinate coordinate = new Coordinate();

    /**
     * Set the related Coordinate to be Manipulated
     *
     * @param coordinate The related Coordinate
     */
    public Command coordinate(Coordinate coordinate) {
        this.coordinate = coordinate;

        return this;
    }

    /**
     * Get's the Code of the Command
     *
     * @return Letter Code of the Command
     */
    public char code() {
        return ' ';
    }
}

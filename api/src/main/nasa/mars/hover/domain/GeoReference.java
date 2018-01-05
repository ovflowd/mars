package nasa.mars.hover.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;

/**
 * GeoReference Enumerator
 *
 * Used to assign which position stands the hover
 * @version 1.0
 * @author @sant0ro
 */
@Component
public class GeoReference implements Serializable {

    /**
     * Cardinal Direction for
     * the North direction as 90º degrees
     */
    public final static int NORTH = 90;

    /**
     * Cardinal Direction for
     * the West direction as 180 degrees
     */
    public final static int WEST = 180;

    /**
     * Cardinal Direction for
     * the South direction as 270 degrees
     */
    public final static int SOUTH = 270;

    /**
     * Cardinal Direction for
     * the East direction as 0/360º degrees
     */
    public final static int EAST = 0;

    /**
     * Coordinate relative to this GeoReference
     */
    private Coordinate coordinate;

    /**
     * Creates an Instance of the GeoReference
     *
     * @param coordinate The related Coordinate
     */
    @Autowired
    GeoReference(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * This Autowired Constructor should not be called.
     *
     * @throws RuntimeException We cannot use this, since we inject dependencies
     */
    private GeoReference() throws RuntimeException {
        throw new RuntimeException("This should not be called.");
    }

    /**
     * Update the GeoReference from a Coordinate
     *
     * @param command the following command
     */
    public void updateHeading(char command) {
        switch(command) {
            case 'L':
                coordinate.heading = (coordinate.heading == 270 ? 0 : coordinate.heading + 90);
                break;
            case 'R':
                coordinate.heading = (coordinate.heading == 0 ? 270 : coordinate.heading - 90);
                break;
            default:
                break;
        }
    }

    /**
     * Update the GeoReference Coordinates Position
     */
    public void updatePosition() {
        switch(coordinate.heading) {
            case NORTH:
                coordinate.position.y++;
                break;
            case EAST:
                coordinate.position.x++;
                break;
            case SOUTH:
                coordinate.position.y--;
                break;
            case WEST:
                coordinate.position.x--;
                break;
        }
    }

    /**
     * Get the Geo Reference Code of a specific heading
     *
     * @return the geo heading code
     */
    public char headingCode() {
        switch(coordinate.heading) {
            default:
            case NORTH:
                return 'N';
            case EAST:
                return 'E';
            case SOUTH:
                return 'S';
            case WEST:
                return 'W';
        }
    }
}

package nasa.mars.hover.service.iterator;

import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.enumerator.Cardinal;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * GeoReference Iterator
 *
 * A Iterator Design Pattern, used to iterate through
 *  the Coordinate heading and Position and update their values
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@Service
public class GeoReference implements Serializable {

    /**
     * Coordinate relative to this GeoReference
     */
    private Coordinate coordinate;

    /**
     * Update the GeoReference from a Coordinate
     *
     * @param command the following command
     */
    public void updateHeading(char command) {
        switch(command) {
            case 'L':
                coordinate.heading = (coordinate.heading == Cardinal.SOUTH ? Cardinal.EAST : Cardinal.valueOf(coordinate.heading.getAngle() + 90));
                break;
            case 'R':
                coordinate.heading = (coordinate.heading == Cardinal.EAST ? Cardinal.SOUTH : Cardinal.valueOf(coordinate.heading.getAngle() - 90));
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
                coordinate.y++;
                break;
            case EAST:
                coordinate.x++;
                break;
            case SOUTH:
                coordinate.y--;
                break;
            case WEST:
                coordinate.x--;
                break;
        }
    }

    /**
     * Set the Coordinate for the GeoReference Service
     *
     * @param coordinate desired coordinate
     * @return this instance (Fluent Setter)
     */
    public GeoReference setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;

        return this;
    }
}

package nasa.mars.hover.service.iterator;

import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.enumerator.Cardinal;
import nasa.mars.hover.service.Iterator;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;

/**
 * Command Iterator
 *
 * A Iterator that works with given Interpreted Commands
 *  and Iterate through they
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@Service
@Scope("prototype")
public class CommandIterator implements Serializable, Iterator<List<Character>, Coordinate> {

    /**
     * Coordinate Instance
     */
    private Coordinate coordinate;

    /**
     * Set the Predicated Manipulator
     *
     * @param coordinate Coordinate Instance
     */
    @Override
    public void predicate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Iterate through T object
     *
     * @param commands Command List
     */
    @Override
    public void iterate(List<Character> commands) {
        commands.forEach(command -> {
            switch (command) {
                case 'R':
                case 'L':
                    updateHeading(command);
                    break;
                case 'M':
                    updatePosition();
                    break;
            }
        });
    }

    /**
     * Update the GeoReference from a Coordinate
     *
     * @param command the following command
     */
    private void updateHeading(char command) {
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
    private void updatePosition() {
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
}

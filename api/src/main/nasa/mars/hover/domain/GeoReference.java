package nasa.mars.hover.domain;

/**
 * GeoReference Enumerator
 *
 * Used to assign which position stands the hover
 * @version 1.0
 * @author @sant0ro
 */
public class GeoReference {

    public final static int NORTH = 90; // 90 degrees

    public final static int EAST = 180; // 180 degrees

    public final static int SOUTH = 270; // 270 degrees

    public final static int WEST = 0; // 0 or 360 degrees

    /**
     * Update the GeoReference from a Coordinate
     *
     * @param c the related Coordinate object
     * @param command the following command
     */
    public static void updateGeoReference(Coordinate c, char command) {
        switch(command) {
            case 'L':
                c.heading = (c.heading == 270 ? 0 : c.heading + 90);
                break;
            case 'R':
                c.heading = (c.heading == 0 ? 270 : c.heading - 90);
                break;
            default:
                break;
        }
    }

    /**
     * Update the GeoReference Coordinates Position
     *
     * @param c the related Coordinate object
     */
    public static void updateGeoPosition(Coordinate c) {
        switch(c.heading) {
            case NORTH:
                c.position.x++;
                break;
            case EAST:
                c.position.y--;
                break;
            case SOUTH:
                c.position.x--;
                break;
            case WEST:
                c.position.y++;
                break;
        }
    }

    /**
     * Get the Geo Reference Code of a specific heading
     *
     * @param c the related Coordinate object
     * @return the geo heading code
     */
    public static char getGeoReference(Coordinate c) {
        switch(c.heading) {
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

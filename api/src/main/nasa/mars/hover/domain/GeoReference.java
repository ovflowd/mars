package nasa.mars.hover.domain;

/**
 * GeoReference Enumerator
 *
 * Used to assign which position stands the hover
 * @version 1.0
 * @author @sant0ro
 */
public enum GeoReference {

    NORTH(0, 'N'), // North, 90 degrees
    EAST(1, 'E'), // East, 180 degrees
    SOUTH(2, 'S'), // South, 270 degrees
    WEST(3, 'W'); // West, 0 or 360 degrees

    /**
     * The position in a 360º degree reference
     */
    private final int position;

    /**
     * The output code of the geo reference angle
     */
    private final char code;

    /**
     * Specifies the behaviour of this Enumerator
     *
     * @param position Position Identifier for the heading of the hover
     * @param code the output letter (single character) of the hover heading
     */
    GeoReference(int position, char code) {
        this.position = position;
        this.code = code;
    }

    public char getCode() {
        return code;
    }

    public int getPosition() {
        return position;
    }
}

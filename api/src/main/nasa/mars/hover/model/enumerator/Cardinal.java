package nasa.mars.hover.model.enumerator;

import java.util.HashMap;
import java.util.NoSuchElementException;

/**
 * Cardinal Enumerator
 *
 * Used to store the Cardinal Positions of
 *  valid Headings
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.1
 */
public enum Cardinal {

    /**
     * Cardinal Direction for
     * the North direction as 90º degrees
     */
    NORTH(90, 'N'),

    /**
     * Cardinal Direction for
     * the West direction as 180 degrees
     */
    WEST(180, 'W'),

    /**
     * Cardinal Direction for
     * the South direction as 270 degrees
     */
    SOUTH(270, 'S'),

    /**
     * Cardinal Direction for
     * the East direction as 0/360º degrees
     */
    EAST(0, 'E');

    /**
     * Angle of the Cardinal Direction,
     *  using the trigonometric circle
     */
    private int angle;

    /**
     * Cardinal Letter Code, used for
     *  output and convenience
     */
    private char code;

    /**
     * Static Map with all the elements of this Enumerator
     */
    private static HashMap<Integer, Cardinal> map = new HashMap<>();

    /**
     * Creates an Instance of the Cardinal Enumerator
     *
     * @param angle Desired angle from 0 to 360
     * @param code Letter Code
     */
     Cardinal(int angle, char code) {
        this.angle = angle;
        this.code = code;
    }

    static {
        for (Cardinal c : Cardinal.values()) {
            map.put(c.angle, c);
        }
    }

    /**
     * Get the Angle in Degrees
     *
     * @return Associated angle
     */
    public int getAngle() {
         return angle;
    }

    /**
     * Get the Letter Code
     *
     * @return Associated Cardinal Letter
     */
    public char getCode() {
         return code;
    }

    /**
     * Get a Cardinal based in a given Angle
     *
     * @param angle A specific angle (divisible by 90)
     * @return The specified Cardinal if exists, if not just null
     */
    public static Cardinal valueOf(int angle) {
        if(angle % 90 != 0)
            throw new NoSuchElementException("Invalid provided Angle, must be divisible by 90º");

        return map.get(angle);
    }
}

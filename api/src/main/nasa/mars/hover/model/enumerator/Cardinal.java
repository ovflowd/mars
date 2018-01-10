package nasa.mars.hover.model.enumerator;

import nasa.mars.hover.aspect.dictionary.AbstractCommand;
import nasa.mars.hover.model.Coordinate;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

/**
 * Cardinal Enumerator
 *
 * Used to store the Cardinal Positions of
 * valid Headings
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.1
 */
public enum Cardinal {

    /**
     * Cardinal Direction for
     * the North direction as 90º degrees
     */
    NORTH(90, 'N', new AbstractCommand() {
        @Override
        public Coordinate execute() {
            coordinate.move(0, 1);

            return coordinate;
        }
    }),

    /**
     * Cardinal Direction for
     * the West direction as 180 degrees
     */
    WEST(180, 'W', new AbstractCommand() {
        @Override
        public Coordinate execute() {
            coordinate.move(-1, 0);

            return coordinate;
        }
    }),

    /**
     * Cardinal Direction for
     * the South direction as 270 degrees
     */
    SOUTH(270, 'S', new AbstractCommand() {
        @Override
        public Coordinate execute() {
            coordinate.move(0, -1);

            return coordinate;
        }
    }),

    /**
     * Cardinal Direction for
     * the East direction as 0/360º degrees
     */
    EAST(0, 'E', new AbstractCommand() {
        @Override
        public Coordinate execute() {
            coordinate.move(1, 0);

            return coordinate;
        }
    });

    /**
     * Angle of the Cardinal Direction,
     * using the trigonometric circle
     */
    private int angle;

    /**
     * Cardinal Letter Code, used for
     * output and convenience
     */
    private char code;

    /**
     * Coordinate Move Command
     */
    private AbstractCommand command;

    /**
     * Static Map with all the elements of this Enumerator
     */
    private static List<Cardinal> list;

    /**
     * Creates an Instance of the Cardinal Enumerator
     *
     * @param angle   Desired angle from 0 to 360
     * @param code    Letter Code
     * @param command Coordinate Callback
     */
    Cardinal(int angle, char code, AbstractCommand command) {
        this.angle = angle;
        this.code = code;
        this.command = command;

    }

    static {
        list = Arrays.asList(Cardinal.values());
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
    public static Cardinal byAngle(int angle) {
        if (angle % 90 != 0)
            throw new NoSuchElementException("Invalid provided Angle, must be divisible by 90º");

        return list.stream().filter(c -> c.angle == angle).findFirst().orElse(null);
    }

    /**
     * Get the Move Command Instance
     *
     * @return the Command Instance
     */
    public AbstractCommand getCommand() {
        return command;
    }
}

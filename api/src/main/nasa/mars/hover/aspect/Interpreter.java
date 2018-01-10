package nasa.mars.hover.aspect;

/**
 * Interpreter Interface
 * <p>
 * Using the Interpreter Design Pattern,
 * to design simple interpreting methods
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.0
 */
public interface Interpreter {

    /**
     * Translate Method
     * <p>
     * Interpreters a given Input into a valid result
     *
     * @param a The input string
     * @return Interpreted/Translated object/String
     */
    Object translate(String a);
}

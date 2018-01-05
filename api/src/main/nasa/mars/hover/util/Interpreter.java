package nasa.mars.hover.util;

import nasa.mars.hover.domain.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Interpreter Utility
 * <p>
 * Validates and converts the Input Marcian Strin into a Coordinate
 *
 * @author @sant0ro
 * @version 1.0
 */
@Component
public class Interpreter implements Serializable {

    /**
     * Coordinate used for the Interpreter usage
     */
    private Coordinate coordinate;

    /**
     * Creates a new Interpreter Instance
     *
     * @param coordinate Specified Coordinate
     */
    @Autowired
    public Interpreter(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Translate the Input String into a Coordinate
     *
     * @param hash input string
     * @return desired Coordinate
     */
    public Coordinate translate(String hash) {
        List<Character> commands = hash.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        if (!commands.stream().allMatch(Character::isLetter))
            throw new RuntimeException("Invalid Command String Specified");

        if (!commands.stream().allMatch(c -> (c == 'L' || c == 'R' || c == 'M')))
            throw new RuntimeException("Only L, R and M are valid commands");

        commands.forEach(command -> {
            switch (command) {
                case 'R':
                case 'L':
                    coordinate.reference.updateHeading(command);
                    break;
                case 'M':
                    coordinate.reference.updatePosition();
                    break;
            }
        });

        return coordinate;
    }
}

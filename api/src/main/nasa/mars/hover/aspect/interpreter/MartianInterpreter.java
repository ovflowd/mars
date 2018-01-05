package nasa.mars.hover.aspect.interpreter;

import nasa.mars.hover.aspect.Interpreter;
import nasa.mars.hover.model.Coordinate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Martian Interpreter
 *
 * Validates and converts the Martian Input String into a Coordinate
 *
 * @author @sant0ro
 * @version 1.1
 * @since 1.0
 */
@Service
@Scope("prototype")
public class MartianInterpreter implements Serializable, Interpreter {

    /**
     * Coordinate used for the Interpreter usage
     */
    @Autowired
    private Coordinate coordinate;

    /**
     * Creates a new Interpreter Instance
     *
     * @param coordinate Specified Coordinate
     */
    public MartianInterpreter(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    /**
     * Translate the Input String into a Coordinate
     *
     * @param hash input string
     * @return result Coordinate
     */
    public Coordinate translate(String hash) {
        List<Character> commands = hash.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        if (!commands.stream().allMatch(Character::isLetter))
            throw new RuntimeException("Invalid Command String Specified");

        if (!commands.stream().allMatch(c -> (c == 'L' || c == 'R' || c == 'M')))
            throw new RuntimeException("Only L, R and M are valid commands");

        coordinate.reset();

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

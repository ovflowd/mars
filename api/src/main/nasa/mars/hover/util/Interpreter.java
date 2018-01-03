package nasa.mars.hover.util;

import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.GeoReference;

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
public class Interpreter {

    /**
     * Translate the Input String into a Coordinate
     *
     * @param hash input string
     * @return desired Coordinate
     */
    public static Coordinate translate(String hash) {
        List<Character> commands = hash.chars().mapToObj(i -> (char) i).collect(Collectors.toList());

        if (!commands.stream().allMatch(Character::isLetter))
            return null;

        if (!commands.stream().allMatch(c -> (c == 'L' || c == 'R' || c == 'M')))
            return null;

        Coordinate coordinate = new Coordinate(0, 0, GeoReference.NORTH);

        commands.forEach(command -> {
            switch (command) {
                case 'R':
                case 'L':
                    GeoReference.updateGeoReference(coordinate, command);
                    break;
                case 'M':
                    GeoReference.updateGeoPosition(coordinate);
                    break;
            }
        });

        return coordinate;
    }
}

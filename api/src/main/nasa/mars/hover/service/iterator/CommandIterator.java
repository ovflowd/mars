package nasa.mars.hover.service.iterator;

import nasa.mars.hover.aspect.Command;
import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.service.Iterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Command Iterator
 * <p>
 * A Iterator that works with given Interpreted Commands
 * and Iterate through they
 *
 * @author @sant0ro
 * @version 1.2
 * @since 1.0
 */
@Service
@Scope("prototype")
public class CommandIterator implements Iterator<List<Character>, Coordinate> {

    /**
     * All available Commands
     * loaded by Spring Context
     */
    public final List<Command> commands;
    /**
     * Coordinate Instance
     */
    private Coordinate coordinate;

    /**
     * Creates a new Command Iterator
     *
     * @param commands All the available commands
     */
    @Autowired
    public CommandIterator(List<Command> commands) {
        this.commands = commands;
    }

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
        commands.forEach(command -> this.commands.stream().filter(c -> c.code() == command).findFirst()
                .orElseThrow(RuntimeException::new).coordinate(this.coordinate).execute());
    }
}

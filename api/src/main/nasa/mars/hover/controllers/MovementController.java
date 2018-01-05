package nasa.mars.hover.controllers;

import nasa.mars.hover.Engine;
import nasa.mars.hover.aspect.interpreter.MartianInterpreter;
import nasa.mars.hover.model.Coordinate;
import nasa.mars.hover.model.Hover;
import nasa.mars.hover.model.Map;
import nasa.mars.hover.service.builder.CuriosityHoverBuilder;
import nasa.mars.hover.service.builder.MarsMapBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class MovementController {

    /**
     * Instance of the Application Engine
     */
    @Autowired
    private Engine engine;

    /**
     * Our desired Hover Builder
     */
    @Autowired
    private CuriosityHoverBuilder hoverBuilder;

    /**
     * Our desired Map Builder
     */
    @Autowired
    private MarsMapBuilder marsBuilder;

    /**
     * Instance of our Interpreter
     */
    @Autowired
    private MartianInterpreter interpreter;

    /**
     * Request a Movement of a Hover inside a Map
     *
     * @param commands The Input Command
     * @return The new position if success, an error if not.
     */
    @RequestMapping(method = RequestMethod.POST, value = "/{commands}")
    public ResponseEntity<String> getCoordinate(@PathVariable String commands) {
        try {
            // Translate the input string unto a Coordinate
            Coordinate c = interpreter.translate(commands);

            // Get our default Hover
            Hover curiosity = engine.getHovers().build(hoverBuilder);

            // Get our default Map
            Map map = engine.getMaps().build(marsBuilder);

            // Add hover to map
            map.link(curiosity);

            // Check if is valid and update Coordinate
            if(!map.move(curiosity, c))
                return ResponseEntity.badRequest().body("400 Bad Request");

            // Get Coordinate String
            String cString = curiosity.coordinate().toString();

            // Remove both Map and Hovers, in order to not store history
            engine.getMaps().remove("Mars");

            return ResponseEntity.ok().body(cString);
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body("400 Bad Request");
        }
    }
}

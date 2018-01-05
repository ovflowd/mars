package nasa.mars.hover.controllers;

import nasa.mars.hover.Boot;
import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.Hover;
import nasa.mars.hover.domain.Map;
import nasa.mars.hover.util.Interpreter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class Movement {

    /**
     * Instance of the Application Engine
     */
    @Autowired
    private Boot boot;

    /**
     * Instance of our Interpreter
     */
    @Autowired
    private Interpreter interpreter;

    @RequestMapping(method = RequestMethod.POST, value = "/{commands}")
    public ResponseEntity<String> getCoordinate(@PathVariable String commands) {
        try {
            // Translate the input string unto a Coordinate
            Coordinate c = interpreter.translate(commands);

            // Get our default Hover
            Hover h = boot.addHover("Default Hover");

            // Get our default Map
            Map m = boot.addMap("Mars", 5, 5);

            // Add hover to map
            m.addHover(h);

            // Check if is valid and update Coordinate
            if(!m.updateCoordinate(h, c))
                return ResponseEntity.badRequest().body("400 Bad Request");

            // Get Coordinate String
            String cString = h.coordinate().toString();

            // Remove both Map and Hovers, in order to not store history
            boot.removeMap(m);

            return ResponseEntity.ok().body(cString);
        } catch(RuntimeException e) {
            return ResponseEntity.badRequest().body("400 Bad Request");
        }
    }
}

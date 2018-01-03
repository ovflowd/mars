package nasa.mars.hover.controllers;

import nasa.mars.hover.Boot;
import nasa.mars.hover.domain.Coordinate;
import nasa.mars.hover.domain.Hover;
import nasa.mars.hover.domain.Map;
import nasa.mars.hover.util.Interpreter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class Movement {

    @RequestMapping(method = RequestMethod.GET, value = "/{commands}")
    public ResponseEntity<String> getCoordinate(@PathVariable String commands) {
        // Translate the input string unto a Coordinate
        Coordinate c = Interpreter.translate(commands);

        if(c == null)
            return ResponseEntity.badRequest().body("400 Bad Request");

        // Get our default Hover
        Hover h = Boot.getGame().getHover("Default Hover");

        // Get our default Map
        Map m = Boot.getGame().getMap("Mars");

        // Add hover to map
        m.addHover(h);

        // Check if is valid and update Coordinate
        if(!m.updateCoordinate(h, c))
            return ResponseEntity.badRequest().body("400 Bad Request");

        // Get Coordinate String
        String cString = h.getCoordinate().toString();

        // Remove Hover from Map in order of removing history
        m.removeHover(h);

        return ResponseEntity.ok().body(cString);
    }
}

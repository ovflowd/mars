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
    public ResponseEntity<String> getCoordinate(@PathVariable String commands) throws Exception {
        Coordinate c = Interpreter.translate(commands);

        if(c == null)
            return ResponseEntity.badRequest().body("400 Bad Request");

        Hover h = Boot.getGame().getHover("Default Hover");

        Map m = Boot.getGame().getMap("Mars");

        m.addHover(h);

        if(!m.updatePosition(h, c.position))
            return ResponseEntity.badRequest().body("400 Bad Request");

        return ResponseEntity.ok().body(h.getCoordinate().toString());
    }
}

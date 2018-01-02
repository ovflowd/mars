package nasa.mars.hover.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Coordinate {

    @RequestMapping("/rest/mars")
    public String getCoordinate(@RequestParam(value="newPosition") String newPosition) {
        return "Under development.";
    }
}

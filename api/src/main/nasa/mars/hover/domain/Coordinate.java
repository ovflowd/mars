package nasa.mars.hover.domain;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class Coordinate {

    @RequestMapping(method = RequestMethod.GET, value = "/{commands}")
    public String getCoordinate(@PathVariable String commands) {
        return "Under development.";
    }
}

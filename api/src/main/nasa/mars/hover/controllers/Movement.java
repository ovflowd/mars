package nasa.mars.hover.domain;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/mars")
public class Movement {

    @RequestMapping(method = RequestMethod.GET, value = "/{commands}")
    public String getCoordinate(@PathVariable String commands) {
        return "Under development.";
    }
}

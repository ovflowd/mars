package nasa.mars.hover.unit;

import nasa.mars.hover.Engine;
import nasa.mars.hover.model.Map;
import nasa.mars.hover.service.builder.MoonMapBuilder;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * MapTest
 *
 * Test Creating Maps and Manipulating It
 *
 * @author @sant0ro
 * @version 1.0
 */
@RunWith(JUnitPlatform.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest()
class MapTest {

    @Autowired
    private Engine engine;

    @Autowired
    private MoonMapBuilder mapBuilder;

    @Test
    @DisplayName("Tries to create Maps and Iterate with it")
    void testPathFinder() {
        Map map = engine.getMaps().build(mapBuilder);

        assertEquals(false, map.valid(33, 33));

        assertEquals(true, map.valid(4, 1));

        assertEquals(false, map.valid(-20, 0));
    }
}

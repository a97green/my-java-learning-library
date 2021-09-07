
import core.Line;
import core.Station;
import junit.framework.TestCase;

import java.util.ArrayList;
import java.util.List;

public class RouteCalculatorTest extends TestCase {
    List<Station> rout;
    
    @Override
    protected void setUp() throws Exception {
        rout = new ArrayList<>();

        Line lineOne = new Line(1, "One");
        Line lineTwo = new Line(2, "Two");

        rout.add(new Station("Civic", lineOne));
        rout
    }
}

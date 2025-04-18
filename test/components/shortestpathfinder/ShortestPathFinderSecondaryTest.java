package components.shortestpathfinder;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShortestPathFinderSecondaryTest {

    @Test
    public void testShortestPath_SingleStep() {
        ShortestPathFinder spf = new ShortestPathFinder1L();
        spf.addPath("A", "B", 1.0);
        assertEquals(1.0, spf.shortestPath("A", "B"), 0.001);
    }

    @Test
    public void testShortestPath_MultiStep() {
        ShortestPathFinder spf = new ShortestPathFinder1L();
        spf.addPath("A", "B", 1.0);
        spf.addPath("B", "C", 1.0);
        assertEquals(2.0, spf.shortestPath("A", "C"), 0.001);
    }

    @Test
    public void testShortestPath_NoPath() {
        ShortestPathFinder spf = new ShortestPathFinder1L();
        spf.addLocation("X");
        spf.addLocation("Y");
        assertEquals(Double.POSITIVE_INFINITY, spf.shortestPath("X", "Y"),
                0.001);
    }

    @Test
    public void testToStringOutput() {
        ShortestPathFinder spf = new ShortestPathFinder1L();
        spf.addPath("A", "B", 1.0);
        String result = spf.toString();
        assertTrue(result.contains("A -> B"));
        assertTrue(result.contains("B -> A"));
    }

    @Test
    public void testEquals_SameGraph() {
        ShortestPathFinder spf1 = new ShortestPathFinder1L();
        ShortestPathFinder spf2 = new ShortestPathFinder1L();
        spf1.addPath("A", "B", 1.0);
        spf2.addPath("A", "B", 1.0);
        assertTrue(spf1.equals(spf2));
    }

    @Test
    public void testEquals_DifferentGraph() {
        ShortestPathFinder spf1 = new ShortestPathFinder1L();
        ShortestPathFinder spf2 = new ShortestPathFinder1L();
        spf1.addPath("A", "B", 1.0);
        spf2.addPath("A", "C", 1.0);
        assertFalse(spf1.equals(spf2));
    }

    @Test
    public void testEquals_DifferentType() {
        ShortestPathFinder spf = new ShortestPathFinder1L();
        assertFalse(spf.equals("Not a Graph"));
    }
}

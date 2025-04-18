package components.shortestpathfinder;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ShortestPathFinder1LTest {

    @Test
    public void testAddLocation_NewLocation() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addLocation("A");
        assertTrue(spf.isConnected("A", "A") == false);
    }

    @Test
    public void testAddLocation_DuplicateLocation() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addLocation("A");
        spf.addLocation("A"); // should not add again
        assertFalse(spf.isConnected("A", "A"));
    }

    @Test
    public void testAddLocation_MultipleLocations() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addLocation("A");
        spf.addLocation("B");
        assertFalse(spf.isConnected("A", "B"));
    }

    @Test
    public void testAddPath_NewPath() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addPath("A", "B", 2.0);
        assertTrue(spf.isConnected("A", "B"));
    }

    @Test
    public void testAddPath_ReverseDirection() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addPath("A", "B", 1.0);
        assertTrue(spf.isConnected("B", "A"));
    }

    @Test
    public void testAddPath_SameNode() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addPath("A", "A", 1.0);
        assertTrue(spf.isConnected("A", "A"));
    }

    @Test
    public void testIsConnected_NotConnected() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addLocation("A");
        spf.addLocation("B");
        assertFalse(spf.isConnected("A", "B"));
    }

    @Test
    public void testIsConnected_Connected() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addPath("X", "Y", 5.0);
        assertTrue(spf.isConnected("X", "Y"));
    }

    @Test
    public void testIsConnected_InvalidLocation() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        assertFalse(spf.isConnected("Q", "W"));
    }

    @Test
    public void testClearGraph() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        spf.addPath("A", "B", 1.0);
        spf.clear();
        assertFalse(spf.isConnected("A", "B"));
    }

    @Test
    public void testTransferFrom() {
        ShortestPathFinder1L spf1 = new ShortestPathFinder1L();
        spf1.addPath("A", "B", 3.0);

        ShortestPathFinder1L spf2 = new ShortestPathFinder1L();
        spf2.transferFrom(spf1);

        assertTrue(spf2.isConnected("A", "B"));
        assertFalse(spf1.isConnected("A", "B")); // original should be empty
    }

    @Test
    public void testNewInstance() {
        ShortestPathFinder1L spf = new ShortestPathFinder1L();
        ShortestPathFinder1L copy = spf.newInstance();
        assertNotSame(spf, copy);
    }
}

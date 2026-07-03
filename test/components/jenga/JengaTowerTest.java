package components.jenga;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import org.junit.Test;

public class JengaTowerTest {

    @Test
    public void testAddAndSize() {
        JengaTower tower = new JengaTower1L(new Random(0));
        assertTrue(tower.isEmpty());
        tower.addBlock();
        assertEquals(1, tower.size());
        tower.addBlock();
        assertEquals(2, tower.size());
    }

    @Test
    public void testPullTopStaysStandingOrClears() {
        JengaTower tower = new JengaTower1L(new Random(0));
        tower.addBlock();
        tower.addBlock();
        boolean result = tower.pull();
        assertTrue(result || tower.isEmpty());
    }

    @Test
    public void testPullAtClearsOnCollapse() {
        JengaTower tower = new JengaTower1L(new Random(1));
        tower.addBlock();
        tower.addBlock();
        tower.addBlock();
        boolean result = tower.pullAt(1);
        assertTrue(result || tower.isEmpty());
    }

    @Test
    public void testTrembleClearsOrKeepsTower() {
        JengaTower tower = new JengaTower1L(new Random(2));
        tower.addBlock();
        tower.addBlock();
        boolean result = tower.tremble();
        assertTrue(result || tower.isEmpty());
    }

    @Test
    public void testTransferFromEmptiesSource() {
        JengaTower source = new JengaTower1L(new Random(3));
        source.addBlock();
        source.addBlock();
        JengaTower target = new JengaTower1L(new Random(4));
        target.transferFrom(source);
        assertEquals(2, target.size());
        assertTrue(source.isEmpty());
    }
}

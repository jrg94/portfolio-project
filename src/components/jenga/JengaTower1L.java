package components.jenga;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Kernel implementation for the JengaTower component.
 *
 * <p>
 * Convention: {@code blocks} is never null, and its size represents the number
 * of blocks currently in the tower.
 * </p>
 *
 * <p>
 * Correspondence: the abstract value of this tower is the number of elements in
 * {@code blocks}. An empty list corresponds to an empty tower.
 * </p>
 */
public class JengaTower1L extends JengaTowerSecondary {

    private final List<Object> blocks;
    private final Random random;

    /**
     * Creates an empty Jenga tower using a default random source.
     */
    public JengaTower1L() {
        this(new Random());
    }

    /**
     * Creates an empty Jenga tower using the supplied random source.
     *
     * @param random
     *            the source of randomness for collapse outcomes
     * @requires | random != null
     */
    public JengaTower1L(Random random) {
        if (random == null) {
            throw new IllegalArgumentException("random cannot be null");
        }
        this.blocks = new ArrayList<>();
        this.random = random;
    }

    @Override
    public JengaTower newInstance() {
        return new JengaTower1L(new Random(this.random.nextLong()));
    }

    @Override
    public void clear() {
        this.blocks.clear();
    }

    @Override
    public void transferFrom(JengaTower source) {
        if (source == null) {
            throw new IllegalArgumentException("source cannot be null");
        }
        if (source == this) {
            return;
        }
        this.clear();
        while (!source.isEmpty()) {
            this.blocks.add(new Object());
            source.pullBlock();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.blocks.isEmpty();
    }

    @Override
    public int size() {
        return this.blocks.size();
    }

    @Override
    public void pullBlock() {
        if (this.isEmpty()) {
            throw new IllegalStateException("Cannot pull from an empty tower");
        }
        this.blocks.remove(this.blocks.size() - 1);
    }

    @Override
    public void pullBlockAt(int level) {
        if (level < 0 || level >= this.size()) {
            throw new IllegalArgumentException("Level out of bounds");
        }
        this.blocks.remove(level);
    }

    @Override
    public void shake() {
        if (!this.isEmpty() && this.random.nextDouble() < 0.25) {
            this.clear();
        }
    }

    @Override
    protected void addBlockToTop() {
        this.blocks.add(new Object());
    }

    @Override
    public boolean pull() {
        if (this.isEmpty()) {
            return true;
        }
        if (this.size() == 1) {
            this.clear();
            return true;
        }
        if (this.random.nextDouble() < 1.0 / this.size()) {
            this.clear();
            return false;
        }
        this.pullBlock();
        return true;
    }

    @Override
    public boolean pullAt(int level) {
        if (this.isEmpty()) {
            return true;
        }
        if (level < 0 || level >= this.size()) {
            throw new IllegalArgumentException("Level out of bounds");
        }
        if (this.random.nextDouble() < 0.2) {
            this.clear();
            return false;
        }
        this.pullBlockAt(level);
        return true;
    }

    @Override
    public boolean tremble() {
        if (this.isEmpty()) {
            return true;
        }
        if (this.random.nextDouble() < 0.25) {
            this.clear();
            return false;
        }
        return true;
    }
}

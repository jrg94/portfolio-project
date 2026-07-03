package components.jenga;

/**
 * Secondary abstract class for the JengaTower component.
 */
public abstract class JengaTowerSecondary implements JengaTower {

    @Override
    public void addBlock() {
        this.addBlockToTop();
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
        int collapseChance = this.size();
        if (Math.random() < 1.0 / collapseChance) {
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
        if (Math.random() < 0.2) {
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
        if (Math.random() < 0.25) {
            this.clear();
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "JengaTower[size=" + this.size() + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof JengaTower)) {
            return false;
        }
        JengaTower other = (JengaTower) obj;
        return this.size() == other.size();
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(this.size());
    }

    /**
     * Adds a block directly to the top of the tower. This kernel-like helper is
     * implemented by the concrete class.
     */
    protected abstract void addBlockToTop();
}

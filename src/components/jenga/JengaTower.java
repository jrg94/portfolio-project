package components.jenga;

/**
 * Enhanced interface for the JengaTower component.
 */
public interface JengaTower extends JengaTowerKernel {

    /**
     * Adds a block to the top of the tower.
     *
     * @updates | this
     * @ensures | this.size() == old(this.size()) + 1
     */
    void addBlock();

    /**
     * Pulls the top block and returns whether the tower remains standing.
     *
     * @return {@code true} if the tower is still standing after the pull;
     *         {@code false} if it collapsed.
     */
    boolean pull();

    /**
     * Pulls a block from the specified zero-based level from the bottom. If the
     * tower collapses, the tower becomes empty.
     *
     * @param level
     *            zero-based height of the block from the base
     * @return {@code true} if the tower is still standing after the pull;
     *         {@code false} if it collapsed.
     */
    boolean pullAt(int level);

    /**
     * Trembles the tower and returns whether it still stands after the shake.
     *
     * @return {@code true} if the tower remains standing; {@code false} if it
     *         collapsed.
     */
    boolean tremble();
}

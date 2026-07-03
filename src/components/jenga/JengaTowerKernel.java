package components.jenga;

import components.standard.Standard;

/**
 * Kernel interface for the JengaTower component.
 */
public interface JengaTowerKernel extends Standard<JengaTower> {

    /**
     * Sets the tower to the empty state.
     *
     * @clears | this
     */
    @Override
    void clear();

    /**
     * Transfers the contents of {@code source} into {@code this}. The source is
     * emptied and {@code this} receives the former contents.
     *
     * @param source
     *            the source tower to transfer from
     * @clears | source
     * @updates | this
     * @requires | source != null
     */
    @Override
    void transferFrom(JengaTower source);

    /**
     * Reports whether the tower is empty.
     *
     * @return {@code true} if this tower has no blocks; {@code false}
     *         otherwise.
     */
    boolean isEmpty();

    /**
     * Reports the number of blocks currently in the tower.
     *
     * @return the block count in this tower
     */
    int size();

    /**
     * Removes the top block from the tower. If the tower is empty, this method
     * has no effect.
     *
     * @updates | this
     * @requires | !this.isEmpty()
     * @ensures | this.size() == old(this.size()) - 1
     */
    void pullBlock();

    /**
     * Attempts to remove a block from a specific height above the base. If the
     * tower collapses as a result, all blocks are removed.
     *
     * @param level
     *            zero-based height of the block to remove from the bottom
     * @updates | this
     * @requires | 0 <= level && level < this.size()
     */
    void pullBlockAt(int level);

    /**
     * Shakes the tower. The tower may collapse and become empty, or remain
     * unchanged.
     *
     * @updates | this
     */
    void shake();
}

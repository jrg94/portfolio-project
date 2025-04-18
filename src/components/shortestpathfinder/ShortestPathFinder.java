package components.shortestpathfinder;

/**
 * Enhanced interface for ShortestPathFinder.
 *
 * <p>
 * Extends {@code ShortestPathFinderKernel} by adding higher-level functionality
 * related to pathfinding.
 * </p>
 */
public interface ShortestPathFinder extends ShortestPathFinderKernel {

    /**
     * Computes the length (cost) of the shortest path between two locations.
     *
     * <p>
     * Depending on the chosen pathfinding algorithm (e.g., Dijkstra's
     * algorithm, A*), if no path exists between the two locations, you may
     * return {@code Double.POSITIVE_INFINITY}, -1, or throw an exception.
     * </p>
     *
     * @param from
     *            the starting location
     * @param to
     *            the target location
     * @return the total cost of the shortest path from {@code from} to
     *         {@code to}
     * @requires <pre>
     * from and to must already exist in this graph
     * </pre>
     * @ensures <pre>
     * shortestPath(from, to) = the minimal total weight of any path
     *                          from {@code from} to {@code to} in the graph;
     * if no path exists, the method returns an implementation-specific value.
     * </pre>
     */
    double shortestPath(String from, String to);
}
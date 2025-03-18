import components.standard.Standard;

/**
 * Kernel interface for ShortestPathFinder.
 *
 * <p>
 * Declares the minimal core methods needed for a graph that manages locations
 * and undirected weighted paths. According to the OSU software component
 * discipline, this kernel interface extends {@code Standard<T>}.
 * </p>
 */
public interface ShortestPathFinderKernel
        extends Standard<ShortestPathFinder1> {

    /**
     * Adds a location (node) to the graph.
     *
     * @param location
     *            the location name (unique identifier)
     * @updates this
     * @ensures <pre>
     * If this graph does not already contain {@code location},
     * then {@code location} is added to the graph;
     * otherwise this graph remains unchanged.
     * </pre>
     */
    void addLocation(String location);

    /**
     * Adds an undirected path (edge) between two locations with a given weight.
     *
     * @param from
     *            the starting location
     * @param to
     *            the destination location
     * @param weight
     *            the weight (cost) of the path
     * @updates this
     * @ensures <pre>
     * If the graph does not contain {@code from} or {@code to}, those
     * locations are added first. Then an undirected edge is added between
     * {@code from} and {@code to} with the specified {@code weight}.
     * </pre>
     */
    void addPath(String from, String to, double weight);

    /**
     * Checks if a direct (immediate) path exists between two locations.
     *
     * @param from
     *            the starting location
     * @param to
     *            the destination location
     * @return true if there is a direct edge from {@code from} to {@code to}
     * @ensures <pre>
     * isConnected = (whether the graph has a direct undirected edge
     *               connecting {@code from} and {@code to})
     * </pre>
     */
    boolean isConnected(String from, String to);

}

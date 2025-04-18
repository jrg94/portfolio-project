package components.shortestpathfinder;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Abstract class that implements secondary methods for ShortestPathFinder using
 * only kernel methods.
 */
public abstract class ShortestPathFinderSecondary
        implements ShortestPathFinder {

    /**
     * Computes the length of the shortest path between two locations using
     * Dijkstra's algorithm with kernel-only methods.
     *
     * <p>
     * This implementation assumes the graph is unweighted and assigns a weight
     * of 1.0 to every edge. If either of the specified locations does not exist
     * in the graph, the method returns {@code Double.POSITIVE_INFINITY}.
     *
     * @param from
     *            the starting location
     * @param to
     *            the target location
     * @return the total cost of the shortest path from {@code from} to
     *         {@code to}, or {@code Double.POSITIVE_INFINITY} if no path exists
     *         or if either location is invalid
     * @requires {@code from} and {@code to} must be valid location names
     *           (non-null)
     * @ensures computes minimal number of hops between {@code from} and
     *          {@code to}
     */
    @Override
    public double shortestPath(String from, String to) {
        if (from == null || to == null || !this.hasLocation(from)
                || !this.hasLocation(to)) {
            return Double.POSITIVE_INFINITY;
        }

        // Dijkstra's Algorithm using only public interface
        Set<String> visited = new HashSet<>();
        Map<String, Double> distance = new HashMap<>();
        Queue<String> queue = new LinkedList<>();

        for (String location : this.getLocations()) {
            distance.put(location, Double.POSITIVE_INFINITY);
        }
        distance.put(from, 0.0);
        queue.add(from);

        while (!queue.isEmpty()) {
            String current = queue.poll();
            visited.add(current);

            for (String neighbor : this.getLocations()) {
                if (this.isConnected(current, neighbor)) {
                    double weight = 1.0; // Assume unweighted for kernel-only version
                    double newDist = distance.get(current) + weight;
                    if (newDist < distance.get(neighbor)) {
                        distance.put(neighbor, newDist);
                        if (!visited.contains(neighbor)) {
                            queue.add(neighbor);
                        }
                    }
                }
            }
        }

        return distance.get(to);
    }

    /**
     * Returns a string representation of the graph, listing each location and
     * the locations it is connected to.
     *
     * <p>
     * Each line in the returned string shows a source location followed by its
     * destination neighbors, separated by spaces.
     *
     * @return a string describing all connections in the graph
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String from : this.getLocations()) {
            sb.append(from).append(" -> ");
            for (String to : this.getLocations()) {
                if (this.isConnected(from, to)) {
                    sb.append(to).append(" ");
                }
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Compares this {@code ShortestPathFinder} with another object for
     * equality.
     *
     * <p>
     * Returns {@code true} if and only if the other object is also an instance
     * of {@code ShortestPathFinder} and contains the same set of locations and
     * the same connections between them.
     *
     * @param obj
     *            the object to compare with
     * @return {@code true} if the graphs are structurally equal, {@code false}
     *         otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ShortestPathFinder)) {
            return false;
        }

        ShortestPathFinder other = (ShortestPathFinder) obj;
        Set<String> thisLocations = this.getLocations();
        Set<String> otherLocations = other instanceof ShortestPathFinderSecondary
                ? ((ShortestPathFinderSecondary) other).getLocations()
                : new HashSet<>();

        if (!thisLocations.equals(otherLocations)) {
            return false;
        }

        for (String from : thisLocations) {
            for (String to : thisLocations) {
                if (this.isConnected(from, to) != other.isConnected(from, to)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return this.toString().hashCode();
    }

    /**
     * Returns a set of all locations in the graph.
     *
     * @return a set of all known locations in the graph
     */
    protected abstract Set<String> getLocations();

    /**
     * Checks whether a location exists.
     *
     * @param location
     *            the location name
     * @return true if exists, false otherwise
     */
    protected boolean hasLocation(String location) {
        return this.getLocations().contains(location);
    }

}
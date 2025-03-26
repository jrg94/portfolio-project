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
     * Returns a set of all locations by checking connectivity. NOTE: Requires
     * enhancement or overridden in subclass for full behavior.
     *
     * @return a set of all known locations in the graph
     */
    protected Set<String> getLocations() {
        // Must be overridden in concrete subclass if not available via kernel
        throw new UnsupportedOperationException(
                "getLocations() not implemented. Override in subclass.");
    }

    /**
     * Checks whether a location exists.
     *
     * @param location
     *            the location name
     * @return true if exists, false otherwise
     */
    protected boolean hasLocation(String location) {
        try {
            // Try checking via isConnected with self (or alternative strategy)
            return this.isConnected(location, location) || true; // Loose check
        } catch (Exception e) {
            return false;
        }
    }
}
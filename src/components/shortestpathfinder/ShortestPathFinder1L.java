package components.shortestpathfinder;

import java.util.HashSet;
import java.util.Set;

import components.map.Map;
import components.queue.Queue;
import components.queue.Queue1L;
import components.standard.Standard;

/**
 * Kernel implementation of ShortestPathFinder component using a map of
 * locations to queues of edges.
 *
 * Convention: - The map contains no null keys. - Each key maps to a queue of
 * Edge objects with non-null destination names and non-negative weights. - The
 * graph is undirected: if A connects to B, then B must also connect to A.
 *
 * Correspondence: - Each map entry (key, queue of Edge) represents a location
 * and its direct paths. - The entire map represents an undirected graph where
 * locations are vertices and Edge objects are undirected edges between them.
 */
public final class ShortestPathFinder1L extends ShortestPathFinderSecondary
        implements ShortestPathFinderKernel, Standard<ShortestPathFinder1L> {

    /**
     * Represents an edge in the graph with a destination and weight.
     */
    private static class Edge {
        /**
         * Name of the destination location for this edge.
         */
        private final String destination;
        /**
         * Weight (cost) associated with this edge.
         */
        private final double weight;

        /**
         * Constructs a new edge to the specified destination with the given
         * weight.
         *
         * @param destination
         *            the name of the destination location
         * @param weight
         *            the weight (cost) of this edge
         */
        Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        /**
         * Returns the destination location of this edge.
         *
         * @return the destination location name
         */
        public String getDestination() {
            return this.destination;
        }

        /**
         * Returns the weight (cost) of this edge.
         *
         * @return the weight of the edge
         */
        public double getWeight() {
            return this.weight;
        }
    }

    public ShortestPathFinder1L() {
        this.graph = new components.map.Map1L<>();
    }

    /**
     * Internal graph representation.
     */
    private final Map<String, Queue<Edge>> graph;

    /**
     * Default constructor.
     */
    @Override
    public ShortestPathFinder1L newInstance() {
        return new ShortestPathFinder1L();
    }

    /**
     * Returns the weight (cost) of this edge.
     */
    @Override
    public void addLocation(String location) {
        if (!this.graph.hasKey(location)) {
            this.graph.add(location, new Queue1L<>());
        }
    }

    @Override
    public void addPath(String from, String to, double weight) {
        this.addLocation(from);
        this.addLocation(to);
        this.graph.value(from).enqueue(new Edge(to, weight));
        this.graph.value(to).enqueue(new Edge(from, weight));
    }

    @Override
    public boolean isConnected(String from, String to) {
        if (!this.graph.hasKey(from)) {
            return false;
        }
        for (Edge e : this.graph.value(from)) {
            if (e.getDestination().equals(to)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        while (this.graph.size() > 0) {
            this.graph.removeAny();
        }
    }

    @Override
    public void transferFrom(ShortestPathFinder1L source) {
        assert source != null : "source is null";
        assert source instanceof ShortestPathFinder1L : "source not instance of ShortestPathFinder1L";
        ShortestPathFinder1L localSource = (ShortestPathFinder1L) source;
        this.graph.transferFrom(localSource.graph);
    }

    @Override
    protected Set<String> getLocations() {
        Set<String> locations = new HashSet<>();
        for (Map.Pair<String, Queue<Edge>> pair : this.graph) {
            locations.add(pair.key());
        }
        return locations;
    }
}
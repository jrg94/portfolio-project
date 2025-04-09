package components.shortestpathfinder;

import java.util.HashSet;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import components.map.Map1L;
import components.queue.Queue1L;

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
public final class ShortestPathFinder1L extends ShortestPathFinderSecondary {

    /**
     * Represents an edge in the graph with a destination and weight.
     */
    private static class Edge {
        private final String destination;
        private final double weight;

        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        public String getDestination() {
            return this.destination;
        }

        public double getWeight() {
            return this.weight;
        }
    }

    /**
     * Internal graph representation.
     */
    private final Map<String, Queue<Edge>> graph;

    /**
     * Default constructor.
     */
    public ShortestPathFinder1L() {
        this.graph = new Map1L<>();
    }

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
    public ShortestPathFinder newInstance() {
        return new ShortestPathFinder1L();
    }

    @Override
    public void transferFrom(ShortestPathFinder source) {
        if (source instanceof ShortestPathFinder1L) {
            ShortestPathFinder1L local = (ShortestPathFinder1L) source;
            while (this.graph.size() > 0) {
                this.graph.removeAny();
            }
            throw new UnsupportedOperationException(
                    "transferFrom not supported due to final field.");
        } else {
            throw new IllegalArgumentException("Invalid source type.");
        }
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
import java.util.Map;
import java.util.Queue;

import components.map.Map1L;
import components.queue.Queue1L;
import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * A program to manage a graph and determine direct connections between
 * locations.
 */
public final class ShortestPathFinder {

    /**
     * Represents an edge in the graph with a destination and weight.
     */
    private static class Edge {
        private final String destination;
        private final double weight;

        /**
         * Constructor initializes an edge.
         *
         * @param destination
         *            The destination node.
         * @param weight
         *            The edge weight.
         */
        public Edge(String destination, double weight) {
            this.destination = destination;
            this.weight = weight;
        }

        /**
         * Returns the destination node.
         *
         * @return The destination.
         */
        public String getDestination() {
            return this.destination;
        }

        /**
         * Returns the edge weight.
         *
         * @return The weight.
         */
        public double getWeight() {
            return this.weight;
        }
    }

    /**
     * Graph representation using OSU components.
     */
    private final Map<String, Queue<Edge>> graph;

    /**
     * Constructor initializes an empty graph.
     */
    public ShortestPathFinder() {
        this.graph = new Map1L<>();
    }

    /**
     * Adds a location (node) to the graph.
     *
     * @param location
     *            The location name.
     */
    public void addLocation(String location) {
        if (!this.graph.hasKey(location)) {
            this.graph.add(location, new Queue1L<>());
        }
    }

    /**
     * Adds a path (edge) between two locations with a given weight.
     *
     * @param from
     *            The starting location.
     * @param to
     *            The destination location.
     * @param weight
     *            The weight of the path.
     */
    public void addPath(String from, String to, double weight) {
        this.addLocation(from);
        this.addLocation(to);
        this.graph.value(from).enqueue(new Edge(to, weight));
        this.graph.value(to).enqueue(new Edge(from, weight)); // Undirected graph
    }

    /**
     * Checks if a direct path exists between two locations.
     *
     * @param from
     *            The starting location.
     * @param to
     *            The destination location.
     * @return True if directly connected, false otherwise.
     */
    public boolean isConnected(String from, String to) {
        if (!this.graph.hasKey(from)) {
            return false;
        }
        for (Edge edge : this.graph.value(from)) {
            if (edge.getDestination().equals(to)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Main method.
     *
     * @param args
     *            Command-line arguments, unused.
     */
    public static void main(String[] args) {
        /*
         * Open input and output streams
         */
        SimpleReader input = new SimpleReader1L();
        SimpleWriter output = new SimpleWriter1L();

        /*
         * Initialize ShortestPathFinder
         */
        ShortestPathFinder spf = new ShortestPathFinder();

        /*
         * Add locations
         */
        spf.addLocation("A");
        spf.addLocation("B");
        spf.addLocation("C");

        /*
         * Add paths
         */
        spf.addPath("A", "B", 5);
        spf.addPath("B", "C", 2);

        /*
         * Check connections
         */
        output.println("Is A connected to B? " + spf.isConnected("A", "B")); // Expected: true
        output.println("Is A connected to C? " + spf.isConnected("A", "C")); // Expected: false

        /*
         * Close input and output streams
         */
        input.close();
        output.close();
    }
}

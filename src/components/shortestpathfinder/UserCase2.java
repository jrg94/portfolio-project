package components.shortestpathfinder;

public final class UserCase2 {

    public static void main(String[] args) {
        ShortestPathFinder warehouseMap = new ShortestPathFinder1L();

        // Simulate warehouse layout
        warehouseMap.addPath("DockingStation", "Aisle1", 1.0);
        warehouseMap.addPath("Aisle1", "Aisle2", 1.0);
        warehouseMap.addPath("Aisle2", "ShelfB", 1.0);
        warehouseMap.addPath("Aisle1", "ShelfA", 2.0);
        warehouseMap.addPath("ShelfB", "Exit", 2.0);

        // Query robot's shortest path from start to target shelf
        double cost = warehouseMap.shortestPath("DockingStation", "ShelfB");

        // Print result
        System.out.println(
                "Shortest path from DockingStation to ShelfB: " + cost);
    }
}

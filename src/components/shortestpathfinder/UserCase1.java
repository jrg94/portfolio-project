package components.shortestpathfinder;

public final class UserCase1 {

    public static void main(String[] args) {
        ShortestPathFinder cityMap = new ShortestPathFinder1L();

        // Add locations and paths representing streets
        cityMap.addPath("MainStreet", "Library", 2.0);
        cityMap.addPath("Library", "CityCenter", 3.0);
        cityMap.addPath("MainStreet", "CoffeeShop", 1.0);
        cityMap.addPath("CoffeeShop", "CityCenter", 4.0);

        // Find shortest path from MainStreet to CityCenter
        double cost = cityMap.shortestPath("MainStreet", "CityCenter");

        // Print result
        System.out.println(
                "Shortest distance from MainStreet to CityCenter: " + cost);
    }
}

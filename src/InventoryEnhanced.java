import java.util.Map;

public interface InventoryEnhanced extends InventoryKernel {
    // Add multiple units of an item. Returns true if operation succeeded.
    boolean addItem(String item, int quantity);

    // Get the quantity for an item (0 if absent).
    int getQuantity(String item);

    // Set the quantity for an item. Returns previous quantity.
    int setQuantity(String item, int quantity);

    // Remove all items.
    void clear();

    // Snapshot of item->quantity map.
    Map<String, Integer> snapshot();
}

import java.util.List;

public interface InventoryKernel {
    // Add a single unit of `item`. Returns true if added.
    boolean addItem(String item);

    // Remove a single unit of `item`. Returns true if an item was removed.
    boolean removeItem(String item);

    // Check presence of an item (any quantity > 0).
    boolean contains(String item);

    // Number of unique item types in the inventory.
    int size();

    // Snapshot of item names in insertion order.
    List<String> items();
}

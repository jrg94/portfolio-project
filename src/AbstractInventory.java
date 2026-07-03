import java.util.*;

public abstract class AbstractInventory implements InventoryEnhanced {
    protected final Map<String, Integer> store = new LinkedHashMap<>();

    @Override
    public boolean addItem(String item) {
        return addItem(item, 1);
    }

    @Override
    public boolean addItem(String item, int quantity) {
        if (item == null || item.isEmpty() || quantity <= 0) return false;
        store.put(item, store.getOrDefault(item, 0) + quantity);
        return true;
    }

    @Override
    public boolean removeItem(String item) {
        if (!store.containsKey(item)) return false;
        int q = store.get(item);
        if (q <= 1) store.remove(item);
        else store.put(item, q - 1);
        return true;
    }

    @Override
    public boolean contains(String item) {
        return store.containsKey(item) && store.get(item) > 0;
    }

    @Override
    public int size() {
        return store.size();
    }

    @Override
    public List<String> items() {
        return new ArrayList<>(store.keySet());
    }

    @Override
    public int getQuantity(String item) {
        return store.getOrDefault(item, 0);
    }

    @Override
    public int setQuantity(String item, int quantity) {
        int prev = store.getOrDefault(item, 0);
        if (quantity <= 0) store.remove(item);
        else store.put(item, quantity);
        return prev;
    }

    @Override
    public void clear() {
        store.clear();
    }

    @Override
    public Map<String, Integer> snapshot() {
        return new LinkedHashMap<>(store);
    }
}

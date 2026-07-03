import java.util.Map;

public class InventoryTestsSystematic {
    private static int passed = 0;
    private static int failed = 0;

    private static void expect(String name, boolean cond) {
        if (cond) {
            System.out.println("PASS: " + name);
            passed++;
        } else {
            System.out.println("FAIL: " + name);
            failed++;
        }
    }

    public static void main(String[] args) {
        SimpleInventory inv = new SimpleInventory();

        // Basic add/remove
        expect("initial empty", inv.size() == 0);
        expect("add null rejected", !inv.addItem(null));
        expect("add empty rejected", !inv.addItem(""));
        expect("add negative rejected", !inv.addItem("x", -1));

        expect("add apple x1", inv.addItem("apple"));
        expect("add apple x2", inv.addItem("apple", 2));
        expect("quantity apple == 3", inv.getQuantity("apple") == 3);

        expect("contains apple true", inv.contains("apple"));
        expect("items order preserved", inv.items().get(0).equals("apple"));

        expect("add banana x4", inv.addItem("banana", 4));
        expect("size == 2", inv.size() == 2);

        // setQuantity behavior
        int prev = inv.setQuantity("apple", 1);
        expect("setQuantity returns previous", prev == 3);
        expect("apple now 1", inv.getQuantity("apple") == 1);

        // remove until gone
        expect("remove apple", inv.removeItem("apple"));
        expect("apple gone after remove", inv.getQuantity("apple") == 0 && !inv.contains("apple"));

        // snapshot immutability
        Map<String, Integer> snap = inv.snapshot();
        inv.setQuantity("banana", 1);
        expect("snapshot immutable", snap.get("banana") == 4 && inv.getQuantity("banana") == 1);

        // clear
        inv.clear();
        expect("cleared size 0", inv.size() == 0);

        System.out.println();
        System.out.println("Passed: " + passed + ", Failed: " + failed);
        if (failed > 0) System.exit(2);
    }
}

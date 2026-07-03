public class InventoryTest {
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

        expect("empty at start", inv.size() == 0);

        expect("add apple", inv.addItem("apple"));
        expect("contains apple", inv.contains("apple"));
        expect("quantity apple == 1", inv.getQuantity("apple") == 1);

        expect("add 4 bananas", inv.addItem("banana", 4));
        expect("banana quantity == 4", inv.getQuantity("banana") == 4);

        expect("set apple to 5", inv.setQuantity("apple", 5) == 1);
        expect("apple quantity == 5", inv.getQuantity("apple") == 5);

        expect("remove apple (one)", inv.removeItem("apple"));
        expect("apple quantity == 4", inv.getQuantity("apple") == 4);

        inv.clear();
        expect("cleared", inv.size() == 0 && !inv.contains("banana"));

        System.out.println();
        System.out.println("Tests passed: " + passed + ", failed: " + failed);
        if (failed > 0) System.exit(2);
    }
}

import java.util.Map;

public class WarehouseUseCase {
    public static void main(String[] args) {
        SimpleInventory warehouse = new SimpleInventory();
        warehouse.addItem("widget", 100);
        warehouse.addItem("gadget", 50);

        System.out.println("Warehouse snapshot: " + warehouse.snapshot());

        // simulate shipping 10 widgets
        for (int i = 0; i < 10; i++) warehouse.removeItem("widget");
        System.out.println("After shipping 10 widgets: " + warehouse.getQuantity("widget"));
    }
}

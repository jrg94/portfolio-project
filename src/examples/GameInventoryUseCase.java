public class GameInventoryUseCase {
    public static void main(String[] args) {
        SimpleInventory player = new SimpleInventory();
        player.addItem("potion", 3);
        player.addItem("sword");

        System.out.println("Player items: " + player.snapshot());

        // use a potion
        player.removeItem("potion");
        System.out.println("After using potion: " + player.getQuantity("potion"));
    }
}

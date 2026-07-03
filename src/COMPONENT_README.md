# Inventory Component

This inventory component provides a kernel interface, an enhanced interface, an abstract base class with common behavior, and a simple concrete implementation.

## Files

- `InventoryKernel.java` - Kernel interface with basic operations
- `InventoryEnhanced.java` - Enhanced interface with quantity-aware operations
- `AbstractInventory.java` - Abstract base class providing common behavior
- `SimpleInventory.java` - Concrete implementation
- `test/InventoryTest.java` - Basic test harness
- `test/InventoryTestsSystematic.java` - Comprehensive systematic tests
- `src/examples/WarehouseUseCase.java` - Warehouse simulation use case
- `src/examples/GameInventoryUseCase.java` - Game inventory use case

## Compile and Run

From the repository root:

```powershell
javac -d out src/*.java test/*.java
java -cp out InventoryTestsSystematic
```

Run specific use cases:

```powershell
java -cp out examples.WarehouseUseCase
java -cp out examples.GameInventoryUseCase
```

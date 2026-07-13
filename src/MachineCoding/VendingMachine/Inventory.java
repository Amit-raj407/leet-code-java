package MachineCoding.VendingMachine;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<String, Slot> slots = new ConcurrentHashMap<>();

    public void addSlot(String slotId, Product product, int quantity) {
        slots.put(slotId, new Slot(slotId, product, quantity));
    }

    public Slot getSlot(String slotId) {
        return slots.get(slotId);
    }

    public void refill(String slotId, int quantity) {
        Slot slot = slots.get(slotId);

        if (slot != null) {
            slot.refill(quantity);
        }
    }

    public void displayProducts() {

        System.out.println();

        System.out.println("Available Products");

        slots.values().forEach(System.out::println);

        System.out.println();
    }
}

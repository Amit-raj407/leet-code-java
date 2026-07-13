package MachineCoding.VendingMachine;

import java.util.concurrent.locks.ReentrantLock;

public class Slot {
    private final String slotId;
    private Product product;
    private int quantity;

    private final ReentrantLock lock = new ReentrantLock();

    public Slot(String slotId, Product product, int quantity) {
        this.slotId = slotId;
        this.product = product;
        this.quantity = quantity;
    }

    public String getSlotId() {
        return slotId;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public ReentrantLock getLock() {
        return lock;
    }

    public boolean isEmpty() {
        return quantity == 0;
    }

    public void dispenseOne() {
        if (quantity == 0) {
            throw new IllegalStateException("Out of stock");
        }
        quantity--;
    }

    public void refill(int qty) {
        quantity += qty;
    }

    @Override
    public String toString() {
        return slotId +
                " -> " +
                product +
                " | Qty=" +
                quantity;
    }
}

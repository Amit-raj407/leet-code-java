package MachineCoding.VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class Transaction {

    private Slot selectedSlot;

    private final List<Coin> insertedCoins = new ArrayList<>();

    private int totalAmount;

    public void selectSlot(Slot slot) {
        this.selectedSlot = slot;
    }

    public Slot getSelectedSlot() {
        return selectedSlot;
    }

    public void addCoin(Coin coin) {
        insertedCoins.add(coin);
        totalAmount += coin.getValue();
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public int getChange() {
        return totalAmount - selectedSlot.getProduct().getPrice();
    }

    public void reset() {
        insertedCoins.clear();
        totalAmount = 0;
        selectedSlot = null;
    }
}

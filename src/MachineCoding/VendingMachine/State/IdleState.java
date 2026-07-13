package MachineCoding.VendingMachine.State;

import MachineCoding.VendingMachine.Coin;
import MachineCoding.VendingMachine.Slot;
import MachineCoding.VendingMachine.VendingMachine;

public class IdleState implements State {

    private final VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String slotId) {

        Slot slot = machine.getInventory().getSlot(slotId);

        if (slot == null) {
            throw new IllegalArgumentException("Invalid Slot");
        }

        if (slot.isEmpty()) {
            machine.setState(machine.getOutOfStockState());
            System.out.println("Product Out Of Stock");
            return;
        }

        machine.getTransaction().selectSlot(slot);

        System.out.println(
                "Selected : " +
                slot.getProduct().getName());

        System.out.println(
                "Price : ₹" +
                slot.getProduct().getPrice());

        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Select product first.");
    }

    @Override
    public void dispense() {
        System.out.println("Select product first.");
    }

    @Override
    public void cancel() {
        System.out.println("Nothing to cancel.");
    }
}
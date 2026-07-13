package MachineCoding.VendingMachine.State;

import MachineCoding.VendingMachine.Coin;
import MachineCoding.VendingMachine.Slot;
import MachineCoding.VendingMachine.VendingMachine;

public class DispenseState implements State {

    private final VendingMachine machine;

    public DispenseState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String slotId) {
        System.out.println("Dispensing...");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Already processing.");
    }

    @Override
    public void cancel() {
        System.out.println("Cannot cancel now.");
    }

    @Override
    public void dispense() {

        Slot slot =
                machine.getTransaction().getSelectedSlot();

        slot.getLock().lock();

        try {

            slot.dispenseOne();

            System.out.println(
                    "Dispensed : " +
                    slot.getProduct().getName());

        } finally {

            slot.getLock().unlock();
        }

        machine.setState(machine.getReturnChangeState());

        machine.returnChange();
    }
}

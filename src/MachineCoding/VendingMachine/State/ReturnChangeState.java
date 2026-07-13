package MachineCoding.VendingMachine.State;

import MachineCoding.VendingMachine.Coin;
import MachineCoding.VendingMachine.VendingMachine;

public class ReturnChangeState implements State {

    private final VendingMachine machine;

    public ReturnChangeState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String slotId) {
        System.out.println("Processing...");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Processing...");
    }

    @Override
    public void dispense() {
        System.out.println("Already dispensed.");
    }

    @Override
    public void cancel() {
        System.out.println("Already completed.");
    }

    public void returnChange() {

        int change =
                machine.getTransaction().getChange();

        if (change > 0) {
            System.out.println(
                    "Returning Change : ₹" +
                    change);
        }

        machine.getTransaction().reset();

        machine.setState(machine.getIdleState());
    }
}
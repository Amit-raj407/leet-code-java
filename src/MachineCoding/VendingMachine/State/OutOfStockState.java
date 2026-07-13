package MachineCoding.VendingMachine.State;

import MachineCoding.VendingMachine.Coin;
import MachineCoding.VendingMachine.VendingMachine;

public class OutOfStockState implements State {

    private final VendingMachine machine;

    public OutOfStockState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String slotId) {
        System.out.println("Choose another product.");
    }

    @Override
    public void insertCoin(Coin coin) {
        System.out.println("Cannot accept money.");
    }

    @Override
    public void dispense() {
        System.out.println("Nothing to dispense.");
    }

    @Override
    public void cancel() {

        machine.getTransaction().reset();

        machine.setState(machine.getIdleState());
    }
}

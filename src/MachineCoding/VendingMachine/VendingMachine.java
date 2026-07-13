package MachineCoding.VendingMachine;

import MachineCoding.VendingMachine.State.DispenseState;
import MachineCoding.VendingMachine.State.HasMoneyState;
import MachineCoding.VendingMachine.State.IdleState;
import MachineCoding.VendingMachine.State.OutOfStockState;
import MachineCoding.VendingMachine.State.ReturnChangeState;
import MachineCoding.VendingMachine.State.State;

public class VendingMachine {

    private final Inventory inventory;
    private final Transaction transaction;
    private final PaymentMethod paymentMethod;

    // States
    private final State idleState;
    private final State hasMoneyState;
    private final State dispenseState;
    private final ReturnChangeState returnChangeState;
    private final State outOfStockState;

    private State currentState;

    public VendingMachine() {

        inventory = new Inventory();
        transaction = new Transaction();

        paymentMethod =
                PaymentFactory.getPaymentMethod(PaymentType.CASH);

        idleState = new IdleState(this);
        hasMoneyState = new HasMoneyState(this);
        dispenseState = new DispenseState(this);
        returnChangeState = new ReturnChangeState(this);
        outOfStockState = new OutOfStockState(this);

        currentState = idleState;
    }

    public void displayProducts() {
        inventory.displayProducts();
    }

    public void selectProduct(String slotId) {
        currentState.selectProduct(slotId);
    }

    public void insertCoin(Coin coin) {
        currentState.insertCoin(coin);
    }

    public void dispense() {
        currentState.dispense();
    }

    public void cancel() {
        currentState.cancel();
    }

    public void returnChange() {
        returnChangeState.returnChange();
    }

    // ---------------- Getters ----------------

    public Inventory getInventory() {
        return inventory;
    }

    public Transaction getTransaction() {
        return transaction;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public State getIdleState() {
        return idleState;
    }

    public State getHasMoneyState() {
        return hasMoneyState;
    }

    public State getDispenseState() {
        return dispenseState;
    }

    public ReturnChangeState getReturnChangeState() {
        return returnChangeState;
    }

    public State getOutOfStockState() {
        return outOfStockState;
    }

    public void setState(State state) {
        currentState = state;
    }
}

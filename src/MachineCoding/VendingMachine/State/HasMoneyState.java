package MachineCoding.VendingMachine.State;

import MachineCoding.VendingMachine.Coin;
import MachineCoding.VendingMachine.PaymentMethod;
import MachineCoding.VendingMachine.VendingMachine;

public class HasMoneyState implements State {

    private final VendingMachine machine;

    public HasMoneyState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(String slotId) {
        System.out.println("Product already selected.");
    }

    @Override
    public void insertCoin(Coin coin) {

        PaymentMethod payment = machine.getPaymentMethod();

        payment.pay(machine.getTransaction(), coin);

        int inserted =
                machine.getTransaction().getTotalAmount();

        int price =
                machine.getTransaction()
                        .getSelectedSlot()
                        .getProduct()
                        .getPrice();

        System.out.println(
                "Inserted : ₹" + inserted);

        if (inserted >= price) {
            machine.setState(machine.getDispenseState());
            machine.dispense();
        }
    }

    @Override
    public void dispense() {
        System.out.println("Insert sufficient money.");
    }

    @Override
    public void cancel() {

        int refund =
                machine.getPaymentMethod()
                        .refund(machine.getTransaction());

        System.out.println("Refund : ₹" + refund);

        machine.setState(machine.getIdleState());
    }
}

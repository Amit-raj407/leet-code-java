package MachineCoding.VendingMachine;

public interface PaymentMethod {
    void pay(Transaction transaction, Coin coin);
    int refund(Transaction transaction);
}

package MachineCoding.VendingMachine;

public class CashPayment implements PaymentMethod {

    @Override
    public void pay(Transaction transaction, Coin coin) {
        transaction.addCoin(coin);
    }

    @Override
    public int refund(Transaction transaction) {
        int refundAmount = transaction.getTotalAmount();
        transaction.reset();
        return refundAmount;
    }
    
}

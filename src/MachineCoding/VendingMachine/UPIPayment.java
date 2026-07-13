package MachineCoding.VendingMachine;

public class UPIPayment implements PaymentMethod {

    @Override
    public void pay(Transaction transaction, Coin coin) {
        // validate payment from gateway
        System.out.println("UPI Payment Successful");
    }

    @Override
    public int refund(Transaction transaction) {
        // trigger refund API
        return transaction.getTotalAmount();
    }
    
}

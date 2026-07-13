package MachineCoding.VendingMachine;

public class PaymentFactory {
    private PaymentFactory() {}

    public static PaymentMethod getPaymentMethod(PaymentType type) {
        switch (type) {
            case CASH:
                return new CashPayment();
            case UPI:
                return new UPIPayment();
        
            default:
                throw new IllegalArgumentException("Unsupported Payment Type");
        }
    }
}

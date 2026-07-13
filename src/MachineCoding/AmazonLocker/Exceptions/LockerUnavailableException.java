package MachineCoding.AmazonLocker.Exceptions;

public class LockerUnavailableException extends RuntimeException {
    public LockerUnavailableException() {
        super("No Compartment Available");
    }
}

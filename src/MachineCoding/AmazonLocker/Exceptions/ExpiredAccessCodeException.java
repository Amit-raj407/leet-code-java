package MachineCoding.AmazonLocker.Exceptions;

public class ExpiredAccessCodeException extends RuntimeException {
    public ExpiredAccessCodeException() {
        super("Access code has expired");
    }
}

package MachineCoding.AmazonLocker.Exceptions;

public class InvalidAccessCodeException extends RuntimeException {
    public InvalidAccessCodeException() {
        super("Invalid access code");
    }
}

package vendingMachine.exceptions;

public class NotMoneyAvailableFoundException extends RuntimeException {

    public NotMoneyAvailableFoundException(String message) {
        super(message);
    }
}

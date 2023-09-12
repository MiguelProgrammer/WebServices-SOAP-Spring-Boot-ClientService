package service.exception;

public class FailureDeleteCustomerException extends RuntimeException {
    public FailureDeleteCustomerException(String s, Integer id) {
        super(s);
        System.err.println(s);
    }
}

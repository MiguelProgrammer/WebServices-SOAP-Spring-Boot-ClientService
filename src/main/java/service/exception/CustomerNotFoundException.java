package service.exception;


public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(String s) {
        super(s);
        System.err.println(s);
    }
}

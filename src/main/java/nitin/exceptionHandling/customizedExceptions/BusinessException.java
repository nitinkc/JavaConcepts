package nitin.exceptionHandling.customizedExceptions;


public class BusinessException extends Exception {
    public BusinessException() {
        super();
        System.err.print("Business Exception");
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Exception e) {
        super(e);
    }
}

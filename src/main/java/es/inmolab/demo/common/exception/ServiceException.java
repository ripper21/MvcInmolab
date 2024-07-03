package es.inmolab.demo.common.exception;

public class ServiceException extends Exception {
    private final String errorCode;

    public ServiceException(String message, String errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }
}

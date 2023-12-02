package by.nata.exception;

public class InstantiateException extends RuntimeException {

    public InstantiateException(String message) {
        super(message);
    }

    public InstantiateException(String message, Throwable cause) {
        super(message, cause);
    }
}

package dk.sds.nsp.maternity.data.exceptions;

public class DataBlockedException extends Exception {
    public DataBlockedException(String message) {
        super(message);
    }

    public DataBlockedException(String message, Throwable cause) {
        super(message, cause);
    }
}

package dk.sds.nsp.maternity.data.care_plan.exceptions;

public class DataBlockedException extends Exception {
    public DataBlockedException(String message) {
        super(message);
    }

    public DataBlockedException(String message, Throwable cause) {
        super(message, cause);
    }
}

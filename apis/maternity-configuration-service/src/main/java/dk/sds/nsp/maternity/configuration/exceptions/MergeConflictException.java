package dk.sds.nsp.maternity.configuration.exceptions;

public class MergeConflictException extends Exception {
    public MergeConflictException(String message) {
        super(message);
    }

    public MergeConflictException(String message, Throwable cause) {
        super(message, cause);
    }
}

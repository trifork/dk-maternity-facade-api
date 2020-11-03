package dk.sds.nsp.maternity.lexicon.exceptions;

import dk.sds.nsp.maternity.lexicon.model.ProblemDetailsInvalidparams;

import java.util.ArrayList;
import java.util.List;

public class IllegalParameterValueException extends Exception {
    private List<ProblemDetailsInvalidparams> illegalParameters = new ArrayList<>();

    public IllegalParameterValueException(List<ProblemDetailsInvalidparams> illegalParameters) {
        super();
        this.illegalParameters = illegalParameters;
    }

    public IllegalParameterValueException(String message, List<ProblemDetailsInvalidparams> illegalParameters) {
        super(message);
        this.illegalParameters = illegalParameters;
    }

    public IllegalParameterValueException(String message, Throwable cause, List<ProblemDetailsInvalidparams> illegalParameters) {
        super(message, cause);
        this.illegalParameters = illegalParameters;
    }

    public List<ProblemDetailsInvalidparams> getIllegalParameters() {
        return illegalParameters;
    }
}

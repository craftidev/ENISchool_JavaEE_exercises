package perso.id.app.database.lunch_feature.errors;

import java.util.ArrayList;
import java.util.List;

public class LogicException extends Exception {
    private List<Integer> errorCodes;

    public LogicException() {
        super();
        errorCodes = new ArrayList<>();
    }

    public void addErrorCode(int code) {
        if (!errorCodes.contains(code)) {
            errorCodes.add(code);
        }
    }

    public boolean hasError() {
        return (errorCodes.size() > 0);
    }

    public List<Integer> getErrorCodes() {
        return errorCodes;
    }
}

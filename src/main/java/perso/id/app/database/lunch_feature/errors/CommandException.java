package perso.id.app.database.lunch_feature.errors;

import java.util.ArrayList;
import java.util.List;

public class CommandException extends Exception {
    private List<Integer> errorCodes;

    public CommandException() {
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

package perso.id.app.database.lunch_feature.errors;

/**
 * Custom error code. Range between 10000 & 99999:
 * - CommandException 10001 - 19999
 */
public class ErrorCodes {
    // CommandException 10001 - 19999
    public static final int INSERT_OBJECT_NULL = 10000;
    public static final int INSERT_OBJECT_FAIL = 10000;
    public static final int INSERT_MEAL_FAIL = 10000;
    // LogicException 20001 - 29999
    public static final int RULE_MEAL_ID = 20000;
    public static final int RULE_MEAL_DATE = 20000;
    public static final int RULE_MEAL_FODDCOMPOSITIONID_NULL = 20000;
    public static final int RULE_MEAL_FODDCOMPOSITIONID = 20000;
    public static final int RULE_FOOD_ID = 20000;
    public static final int RULE_FOOD_NAME = 20000;
    public static final int RULE_FOOD_DESCRIPTION = 20000;
}

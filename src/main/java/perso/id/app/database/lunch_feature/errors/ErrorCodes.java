package perso.id.app.database.lunch_feature.errors;
/**
 * Custom error code. Range between 10000 & 99999:
 * - CommandException 10001 - 19999
 */
public class ErrorCodes {
    // CommandException 10001 - 19999
    public static final int INSERT_OBJECT_NULL = 10001;
    public static final int INSERT_OBJECT_FAIL = 10002;
    public static final int INSERT_MEAL_FAIL = 10003;
    // LogicException 20001 - 29999
    public static final int RULE_MEAL_ID = 10001;
    public static final int RULE_MEAL_DATE = 10002;
    public static final int RULE_MEAL_FODDCOMPOSITIONID_NULL = 10003;
    public static final int RULE_MEAL_FODDCOMPOSITIONID = 10004;
    public static final int RULE_FOOD_ID = 10005;
    public static final int RULE_FOOD_NAME = 10006;
    public static final int RULE_FOOD_DESCRIPTION = 10007;
}

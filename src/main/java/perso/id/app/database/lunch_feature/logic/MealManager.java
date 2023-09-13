package perso.id.app.database.lunch_feature.logic;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import perso.id.app.database.lunch_feature.commands.Factory;
import perso.id.app.database.lunch_feature.commands.MealDAO;
import perso.id.app.database.lunch_feature.errors.CommandException;
import perso.id.app.database.lunch_feature.errors.ErrorCodes;
import perso.id.app.database.lunch_feature.errors.LogicException;
import perso.id.app.database.lunch_feature.models.Meal;

public class MealManager {
    private MealDAO mealDAO;

    public MealManager() {
        mealDAO = Factory.getMealDAO();
    }

    public Meal add(LocalDateTime date, List<Integer> foodCompositionId)
    throws LogicException, CommandException {
        Meal meal = new Meal(date, foodCompositionId);
        LogicException exception = new LogicException();
        
        validateDate(date, exception);
        validateFoodCompositionId(foodCompositionId, exception);

        if (!exception.hasError()) {
            mealDAO.insert(meal);
        }
        else {
            throw exception;
        }

        return meal;
    }

    public void validateDate(LocalDateTime date, LogicException exception) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limitPast = now.minus(14, ChronoUnit.DAYS);
        LocalDateTime limitFuture = now.plus(14, ChronoUnit.DAYS);

        boolean isNotWithinRange =  date.isBefore(limitPast) &&
                                    date.isAfter(limitFuture);

        if (isNotWithinRange) {
            exception.addErrorCode(ErrorCodes.RULE_MEAL_DATE);
        }
    }

    public void validateFoodCompositionId(List<Integer> foodCompositionId, LogicException exception) {
        if (foodCompositionId == null) {
            exception.addErrorCode(ErrorCodes.RULE_MEAL_FODDCOMPOSITIONID_NULL);
        }
        else {
            for (Integer foodId : foodCompositionId) {
                if (!(foodId > 0)) {
                    exception.addErrorCode(ErrorCodes.RULE_MEAL_FODDCOMPOSITIONID);
                    break;
                }
            }
        }
    }
}

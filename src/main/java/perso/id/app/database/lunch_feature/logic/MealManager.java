package perso.id.app.database.lunch_feature.logic;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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

    public void add(String dateInput, String foodCompositionIdInput)
    throws LogicException, CommandException {
        DateTimeFormatter dateFormatter= DateTimeFormatter.ofPattern("yyyy-mm-dd");
        LocalDate localDate = LocalDate.parse(dateInput, dateFormatter);
        String userInputTime = "00:00:00";
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.parse(userInputTime, timeFormatter);
        LocalDateTime date = LocalDateTime.of(localDate, localTime);

        String[] numbers = foodCompositionIdInput.split(",");
        List<Integer> foodCompositionId = new ArrayList<>();
        for (String number : numbers) {
            try {
                Integer converted = Integer.parseInt(number.trim());
                foodCompositionId.add(converted);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number: " + number);
            }
        }

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
    }

    public void validateDate(LocalDateTime date, LogicException exception) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime limitPast = now.minus(14, ChronoUnit.DAYS);
        LocalDateTime limitFuture = now.plus(14, ChronoUnit.DAYS);

        boolean isWithinRange = date.isAfter(limitPast) &&
                                date.isBefore(limitFuture);

        if (isWithinRange) {
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

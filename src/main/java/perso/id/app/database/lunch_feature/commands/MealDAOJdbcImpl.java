package perso.id.app.database.lunch_feature.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import perso.id.app.database.lunch_feature.errors.CommandException;
import perso.id.app.database.lunch_feature.errors.ErrorCodes;
import perso.id.app.database.lunch_feature.models.Meal;

public class MealDAOJdbcImpl implements MealDAO {
    private static final String INSERT = "INSERT INTO Meals(date, foodCompositionIdList) VALUES(?, ?);";
    // private static final String UPDATE = "UPDATE Meals SET(date = ?, foodCompositionIdList = ?) WHERE(ID = ?);";
    // private static final String DELETE = "DELETE FROM Meals WHERE (id=?);";
    private static final String SELECT = "SELECT id, date, foodCompositionIdList FROM Meals";

    @Override
    public void deleteById(int id) throws CommandException {
        if (id < 1) {}

        try (Connection connection = ConnectionProviderJdbcMariaDB.getConnection();) {
            
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public void insert(Meal meal) throws CommandException {
        if (meal == null) {
            CommandException commandException = new CommandException();
            commandException.addErrorCode(ErrorCodes.INSERT_OBJECT_NULL);
            throw commandException;
        }

        try (Connection connection = ConnectionProviderJdbcMariaDB.getConnection();) {
            PreparedStatement query = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            query.setString(1, meal.getDate().toString());
            query.setString(2, meal.getFoodCompositionId().toString());
            query.executeUpdate();

            ResultSet result = query.getGeneratedKeys();
            if (result.next()) {
                meal.setId(result.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public List<Meal> selectAll() throws CommandException {
        List<Meal> result = new ArrayList<>();

        try (Connection connection = ConnectionProviderJdbcMariaDB.getConnection();) {
            PreparedStatement query = connection.prepareStatement(SELECT);

            try (ResultSet resultSet = query.executeQuery()) {
                while (resultSet.next()) {
                    Meal meal = new Meal();

                    meal.setId(resultSet.getInt("id"));
                    Timestamp sqlTimestamp = resultSet.getTimestamp("date");
                    meal.setDate(sqlTimestamp.toLocalDateTime());
                    meal.setFoodCompositionId(strToListIntegers(resultSet.getString("foodCompositionIdList")));

                    result.add(meal);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void update(Meal meal) throws CommandException {
        
    }

    private List<Integer> strToListIntegers(String string) {
        List<Integer> result = new ArrayList<>();
        
        String[] numbers = string.split(",");
        for (String number : numbers) {
            try {
                Integer converted = Integer.parseInt(number.trim()); // Trim to remove leading/trailing spaces
                result.add(converted);
            } catch (NumberFormatException e) {
                // Handle invalid numbers if needed
                System.err.println("Invalid number: " + number);
            }
        }

        return result;
    }
}

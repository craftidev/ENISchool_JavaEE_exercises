package perso.id.app.database.lunch_feature.commands;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import perso.id.app.database.lunch_feature.errors.CommandException;
import perso.id.app.database.lunch_feature.errors.ErrorCodes;
import perso.id.app.database.lunch_feature.models.Food;

public class FoodDAOJdbcImpl implements FoodDAO {
    private static final String INSERT = "INSERT INTO Foods(name, description) VALUES(?, ?);";
    // private static final String UPDATE = "UPDATE Foodss SET(name = ?, description = ?) WHERE(Id = ?);";
    // private static final String DELETE = "DELETE FROM Foods WHERE (Id=?);";
    private static final String SELECT = "SELECT id, name, description FROM Foods";

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
    public void insert(Food food) throws CommandException {
        if (food == null) {
            CommandException commandException = new CommandException();
            commandException.addErrorCode(ErrorCodes.INSERT_OBJECT_NULL);
            throw commandException;
        }

        try (Connection connection = ConnectionProviderJdbcMariaDB.getConnection();) {
            PreparedStatement query = connection.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
            query.setString(1, food.getName());
            query.setString(2, food.getDescription());
            query.executeUpdate();

            ResultSet result = query.getGeneratedKeys();
            if (result.next()) {
                food.setId(result.getInt(1));
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Override
    public List<Food> selectAll() throws CommandException {
        List<Food> result = new ArrayList<>();

        try (Connection connection = ConnectionProviderJdbcMariaDB.getConnection();) {
            PreparedStatement query = connection.prepareStatement(SELECT);

            try (ResultSet resultSet = query.executeQuery()) {
                while (resultSet.next()) {
                    Food food = new Food();
                    food.setId(resultSet.getInt("id"));
                    food.setName(resultSet.getString("name"));
                    food.setDescription(resultSet.getString("description"));
                    result.add(food);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void update(Food food) throws CommandException {
        
    }
}

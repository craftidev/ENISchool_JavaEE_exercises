package perso.id.app.database.lunch_feature.commands;

import java.util.List;

import perso.id.app.database.lunch_feature.errors.CommandException;
import perso.id.app.database.lunch_feature.models.Food;

public interface FoodDAO {
    public void insert(Food food) throws CommandException;
    public void update(Food food) throws CommandException;
    public void deleteById(int id) throws CommandException;
    public List<Food> selectAll() throws CommandException;
}

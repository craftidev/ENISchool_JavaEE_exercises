package perso.id.app.database.lunch_feature.commands;

import java.util.List;

import perso.id.app.database.lunch_feature.errors.CommandException;
import perso.id.app.database.lunch_feature.models.Meal;

public interface MealDAO {
    public void insert(Meal meal) throws CommandException;
    public void update(Meal meal) throws CommandException;
    public void deleteById(int id) throws CommandException;
    public List<Meal> selectAll() throws CommandException;
}

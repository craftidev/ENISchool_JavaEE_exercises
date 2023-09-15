package perso.id.app.database.lunch_feature.commands;

public abstract class Factory {
    public static MealDAO getMealDAO() {
        return new MealDAOJdbcImpl();
    }
    public static FoodDAO getFoodDAO() {
        return new FoodDAOJdbcImpl();
    }
}

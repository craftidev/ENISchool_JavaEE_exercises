package perso.id.app.database.lunch_feature.models;

import java.time.LocalDateTime;
import java.util.List;

public class Meal {
    private Integer id;
    private LocalDateTime date;
    private List<Integer> foodCompositionId;

    public  Meal() {
        this(null, null, null);
    }

    public  Meal(LocalDateTime date, List<Integer> foodCompositionId) {
        this(null, date, foodCompositionId);
    }

    public  Meal(Integer id, LocalDateTime date, List<Integer> foodCompositionId) {
        setId(id);
        setDate(date);
        setFoodCompositionId(foodCompositionId);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public LocalDateTime getDate() {
        return date;
    }
    public void setDate(LocalDateTime date) {
        this.date = date;
    }
    public List<Integer> getFoodCompositionId() {
        return foodCompositionId;
    }
    public void setFoodCompositionId(List<Integer> foodCompositionId) {
        this.foodCompositionId = foodCompositionId;
    }
}
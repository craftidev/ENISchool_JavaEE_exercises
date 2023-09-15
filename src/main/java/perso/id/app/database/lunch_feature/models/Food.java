package perso.id.app.database.lunch_feature.models;

public class Food {
    private Integer id;
    private String name;
    private String description;

    public  Food() {
        this(null, null, null);
    }

    public  Food(Integer id, String name) {
        this(id, name, null);
    }

    public  Food(Integer id, String name, String description) {
        setId(id);
        setName(name);
        setDescription(description);
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}

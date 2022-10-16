package itmo.jjd.hw.task6.product;

public class Product {
    private String name;
    private int proteins;
    private int fats;
    private int carbohydrates;
    private int calories;

    public Product (String name){
        setName(name);
    }
    public Product (String name,int proteins){
        this(name);
        setProteins(proteins);
    }
    public Product(String name, int proteins, int fats){
        this(name, proteins);
        setFats(fats);
    }
    public Product(String name, int proteins, int fats, int carbohydrates){
        this(name, proteins, fats);
        setCarbohydrates(carbohydrates);
    }
    public Product(String name, int proteins, int fats,int carbohydrates, int calories){
        this(name, proteins, fats, carbohydrates);
        setCalories(calories);
    }
    public void setName(String name){
        if (name == null){
            throw new IllegalArgumentException("Название продукта не определено");
        }
        this.name = name;
    }
    public void setProteins(int proteins){
        if(proteins < 0){
            throw new IllegalArgumentException("Значение не м.б. меньше 0");
        }
            this.proteins = proteins;
    }
    public void setFats(int fats){
        if(fats < 0){
            throw new IllegalArgumentException("Значение не м.б. меньше 0");
        }
        this.fats = fats;
    }
    public void setCarbohydrates(int carbohydrates){
        if(carbohydrates < 0){
            throw new IllegalArgumentException("Значение не м.б. меньше 0");
        }
        this.carbohydrates = carbohydrates;
    }
    public void setCalories(int calories){
        if (calories < 0){
            throw new IllegalArgumentException("Значение не м.б. меньше 0");
        }
        this.calories = calories;
    }
    public String getName() {
        return name;
    }

    public int getProteins() {
        return proteins;
    }

    public int getFats() {
        return fats;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public int getCalories() {
        return calories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", proteins=" + proteins +
                ", fats=" + fats +
                ", carbohydrates=" + carbohydrates +
                ", calories=" + calories +
                '}';
    }
}
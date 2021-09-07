import java.util.PrimitiveIterator;

public class Cat {
    private double originWeight;
    private double weight;
    private String name;
    private CatColor color;

    private static int catCount;

    private static final int NUMBER_EYES = 2;
    private static final double MIN_WEIGHT = 1000.0;
    private static final double MAX_WEIGHT = 9000.0;

    public Cat(){
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        catCount++;

    }

    public Cat(CatColor catColor) {
        this();
        setColor(catColor);
    }

    public Cat(String name, CatColor catColor) {
        this(catColor);
        this.name = name;
    }

    public void meow() {
        weight = weight - 1;
        System.out.println("Meow");
    }

    public void feed(Double amount) {
        weight = weight + amount;
    }

    public void drink(Double amount) {
        weight = weight + amount;
    }

    public static int getCatCount() {
        return catCount;
    }

    public int getNumberEyes() {
        return NUMBER_EYES;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public Double getWeight() {
        return weight;
    }

    public void setColor(CatColor color) {
        this.color = color;
    }

    public CatColor getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        if(weight < MIN_WEIGHT) {
            catCount--;
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            catCount--;
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

    public Cat copyCat() {
        Cat cat = new Cat();
        cat.setColor(this.getColor());
        cat.setName(this.getName());
        cat.setWeight(this.getWeight());
        return cat;
    }
}
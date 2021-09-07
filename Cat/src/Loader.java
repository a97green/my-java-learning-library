import java.nio.channels.ScatteringByteChannel;

public class Loader {
    public static Cat newCat(String name, CatColor catColor){
        Cat cat = new Cat(name, catColor);
        return cat;
    }
    public static void main(String[] args) {

        Cat cat = newCat("Хуита", CatColor.BLACK);
        System.out.println(cat.getName());
        System.out.println(cat.getStatus());
        System.out.println(cat.getWeight());
        System.out.println(cat.getColor());
        System.out.println(cat.getNumberEyes());
        System.out.println(Cat.getCatCount());

        Cat catCopy = cat.copyCat();
        System.out.println(catCopy.getName());
        System.out.println(catCopy.getStatus());
        System.out.println(catCopy.getWeight());
        System.out.println(catCopy.getColor());
        System.out.println(catCopy.getNumberEyes());
        System.out.println(Cat.getCatCount());
        System.out.println("Cat: " + cat + " Copy: " + catCopy);
    }
}
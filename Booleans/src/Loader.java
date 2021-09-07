
public class Loader {
    public static void main(String[] args) {
        int milkAmount = 900; // ml
        int powderAmount = 51200; // g
        int eggsCount = 4; // items
        int sugarAmount = 7363; // g
        int oilAmount = 3084; // ml
        int appleCount = 863;

        //powder - 400 g, sugar - 10 g, milk - 1 l, oil - 30 ml
        if (powderAmount >= 400 && sugarAmount >= 10 && milkAmount >= 1 && oilAmount >= 30) {
            System.out.println("Pancakes");
        }

        //milk - 300 ml, powder - 5 g, eggs - 5
        if (milkAmount >= 300 && powderAmount >= 5 && eggsCount >= 5) {
            System.out.println("Omelette");
        }

        //apples - 3, milk - 100 ml, powder - 300 g, eggs - 4
        if (appleCount >= 3 && milkAmount >= 100 && powderAmount >= 300 && eggsCount >= 4) {
            System.out.println("Apple pie");
        }
    }
}
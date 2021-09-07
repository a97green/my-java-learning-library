
public class Loader {
    public static void main(String[] args) {


        
        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";

        System.out.println(text);

        text = text.replaceAll("[^0-9]", " ");

        String[] textArrays = text.split("\\s+");
        int amount = 0;
        for (String s : textArrays) {
            if (s == "") {
                continue;
            }
            amount += Integer.parseInt(s);
        }
        System.out.println("Общая сумма заработка: " + amount + " рублей.");
    }
}
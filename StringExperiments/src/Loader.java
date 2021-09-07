import javax.print.attribute.standard.MediaSize;
import java.util.Scanner;

public class Loader {
    public static  String getName(String name) {
        return name.substring(0, name.indexOf(" "));
    }
    public static void main(String[] args) {
        System.out.println("Введите имя в формате: Фамилия Имя Отчество...");
        Scanner scanner = new Scanner(System.in);
        try {
            String name = scanner.nextLine();
            String oneName = getName(name);
            System.out.println("Фамилия: " + oneName);

            name = name.substring(name.indexOf(" ") + 1);
            String twoName = getName(name);
            System.out.println("Имя: " + twoName);

            name = name.substring(name.indexOf(" ") + 1);
            String threeName = name.substring(0);
            System.out.println("Отчество: " + threeName);
        } catch (StringIndexOutOfBoundsException e) {

        }

        /*-------------------------------------задание 2------------------------------------;--------
        String text = "Вася заработал 50012 рублей, Петя - 736563 рубля, а Маша - 302085 рублей";

        System.out.println(text);

        int amountTotal = 0;

        for (int i = 1; i <= 9; i++) {
            try {
                String searchParameter = " " + (Integer.toString(i));
                String preSearchResult = text.substring(text.indexOf(searchParameter));
                String searchResult = preSearchResult.substring(1, preSearchResult.indexOf(" р"));

                amountTotal += Integer.parseInt(searchResult);
            } catch (StringIndexOutOfBoundsException e) {
                continue;
            }
        }
        System.out.println("Общая сумма заработка: " + amountTotal);

-------------------------------------задание 1--------------------------------------------
        String symbols = "qwertyuiopasdfghjklzxcvbnm";
        for (int i = 0; i < symbols.length(); i++) {
            char symbol = symbols.charAt(i);
            int code = symbol;
            System.out.println(symbol + ": " + code);
        }*/
    }
}
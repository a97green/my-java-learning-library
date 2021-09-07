import java.util.Scanner;

public class Main {
    public static String  searchAndReplaceDiamonds(String text, String placeHolder) {
        String replaceText = "";

        try {
            replaceText = (text.substring(0, text.indexOf("<"))) + placeHolder +
                    (text.substring(text.lastIndexOf(">") + 1));
        } catch (StringIndexOutOfBoundsException e) { }

        return replaceText;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        String placeHolder = "****";
        String replaceText = searchAndReplaceDiamonds(text, placeHolder);
        System.out.println(replaceText);
    }
}

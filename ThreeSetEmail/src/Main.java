import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;

public class Main {
    private static String LIST = "^LIST\\s*$";
    private static String ADD = "^ADD\\s+\\S+@\\S+\\.\\S+\\s*$";
    private static String EXIT = "^EXIT\\s*$";

    private TreeSet<String> emailList = new TreeSet<>();

    public void addEmail(String email) {
        emailList.add(email);
        System.out.println("Email: " + email + " добавлен!");
    }
    public void list() {
        for (String email : emailList) {
            System.out.println(email);
        }
    }
    public void correctCommand(String commandConsole) {
        if (commandConsole.matches(LIST)) {
            list();
        }
        else if (commandConsole.matches(ADD)) {
            String[] command = commandConsole.split(" ");
            String email = command[1];
            addEmail(email);
        }
        else if (commandConsole.matches(EXIT)) {
            System.exit(0);
        }
        else {
            System.out.println("Не корректный Email или команда!");
        }
    }
    public static void main(String[] args) {
        Main play = new Main();
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.print("Введите комманду:");
            String command = scanner.nextLine();
            play.correctCommand(command);
        }
    }
}

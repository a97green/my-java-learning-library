import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    private static String LIST = "LIST";
    private static String NUMBER = "\\d+\\S*\\d*\\S*\\d*\\S*\\d*\\S*\\d*$";
    private static String INFO = "\\S+";


    private TreeMap<String, String> phoneDirectory = new TreeMap<>();

    public void isPhoneDirectoryNumber(String number) {
        if (phoneDirectory.containsKey(number)) {
            System.out.println(number + ": " + phoneDirectory.get(number));
        }
        else {
            System.out.println("Номер не найден! Введите дополнительную информацию для добавления номера!");
            String info = putDirectoryInfo();
            phoneDirectory.put(number,info);
            System.out.println("Номер добавлен!");
        }
    }
    public void isPhoneDirectoryInfo(String info) {
        if (phoneDirectory.containsValue(info)) {
            for (String number : phoneDirectory.keySet()) {
                if (phoneDirectory.get(number).equals(info)) {
                    System.out.println(number + ": " + phoneDirectory.get(number));
                    break;
                }
                else {
                    continue;
                }
            }
        }
        else {
            System.out.println("Информация не найдена! Введите номер для добавления!");
            String number = putDirectoryNumber();
            phoneDirectory.put(number,info);
            System.out.println("Номер добавлен!");
        }
    }
    public String putDirectoryInfo() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public String putDirectoryNumber() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void list() {
        for (String key : phoneDirectory.keySet()) {
            System.out.println(key + ": " + phoneDirectory.get(key));
        }
    }
    public void checkingValue(String value) {
        String text = value.trim();
        if (text.matches(LIST)) {
            list();
        }
        else if (text.matches(NUMBER)) {
            //String number = Integer.parseInt(value);
            isPhoneDirectoryNumber(value);
        }
        else if (text.matches(INFO)) {
            isPhoneDirectoryInfo(value);
        }
        else {
            System.out.println("Неверный формат!");
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Введите номер или имя...");
            main.checkingValue(scanner.nextLine());
        }
    }
}

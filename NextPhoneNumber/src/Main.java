import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите номер телефона!");

        String phoneNumber = scanner.nextLine();

        phoneNumber = phoneNumber.replaceAll("\\+\\d|\\s+|\\-", "");
        System.out.println(phoneNumber);
    }
}

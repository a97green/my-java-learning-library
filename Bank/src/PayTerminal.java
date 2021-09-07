import javax.print.attribute.standard.JobName;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class PayTerminal {
    private static String PAYMENT_ACCOUNT = "1";
    private static String DEPOSIT_ACCOUNT = "2";
    private static String CARD_ACCOUNT = "3";
    private static String TOP_UP = "1";
    private static String TAKE_OFF = "2";
    private static String TRANSFER = "3";
    private static String EXIT = "0";

    private BankAccount bankAccount = new BankAccount();
    private DepositBankAccount depositBankAccount = new DepositBankAccount(LocalDate.now());
    private CardBankAccount cardBankAccount = new CardBankAccount();

    public BankAccount accountSelection(String select) {
        if (select.matches(PAYMENT_ACCOUNT)) {
            return bankAccount;
        }
        else if (select.matches(DEPOSIT_ACCOUNT)) {
            return depositBankAccount;
        }
        else if (select.matches(CARD_ACCOUNT)) {
            return cardBankAccount;
        }
        else {
            System.out.println("Не вырная комманда, попробуйте ещё раз!");
            return accountSelection(new Scanner(System.in).nextLine());
        }
    }

    public void operationSelection(BankAccount account, String select) {
        Scanner scanner = new Scanner(System.in);

        if (select.matches(TOP_UP)) {
            System.out.println("Вставьте сумму пополнения!");
            account.putPaymentAccount(scanner.nextDouble());
        }
        else if (select.matches(TAKE_OFF)) {
            System.out.println("Введите сумму которую хотие снять!");
            account.withdrawPaymentAccount(scanner.nextDouble());
        }
        else if (select.matches(TRANSFER)) {
            System.out.println("Выберите куда хотите перевести:\n        Расчётный счёт - 1\n        Депозитный счёт - 2\n        Счёт карты - 3");
            BankAccount transferAccount = accountSelection(scanner.nextLine());
            System.out.println("Введите сумму перевода!");
            account.send(transferAccount, scanner.nextDouble());
        }
        else if (select.matches(EXIT)) {
            System.out.println("Всего хорошего!");
            System.exit(0);
        }
    }


    public static void main(String[] args) {
        PayTerminal terminal = new PayTerminal();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Выберите тип лицевого счёта:");
            System.out.println("        Расчётный счёт - 1\n        Депозитный счёт - 2\n        Счёт карты - 3 \n        Завершить - 0");

            BankAccount account = null;
            String typeAccount = scanner.nextLine();
            if (typeAccount.matches(EXIT)) {
                System.exit(0);
            }
            else {
                account = terminal.accountSelection(typeAccount);
            }
            while (true) {
                System.out.println("Выберите операцию:");
                System.out.println("        Пополнить - 1\n        Снять - 2\n        Перевести - 3\n        Назад - 0");

                String operation = scanner.nextLine();
                if (operation.matches(EXIT)) {
                    break;
                }
                else {
                    terminal.operationSelection(account, operation);
                }
            }
        }

    }
}

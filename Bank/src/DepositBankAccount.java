import java.time.LocalDate;

public class DepositBankAccount extends BankAccount {
    private static int SURE_DAY = 30;

    private LocalDate dateDeposit;

    private boolean isPutDeposit = false;

    public DepositBankAccount(LocalDate date) {
        super();
        this.dateDeposit = date;
    }

    public void withdrawPaymentAccount(double cash) {
        if (isTransfer(cash)) {
            super.withdrawPaymentAccount(cash);
        }
        else {
            System.out.println("Деньги можно вывести спустя " + SURE_DAY + " дней после пополнения счёта!");
        }
    }

    public boolean isTransfer(double cash) {
        if (getPaymentAccount() >= cash) {
            LocalDate thisDate = LocalDate.now();
            LocalDate withdrawDate = dateDeposit.plusDays((long) SURE_DAY);
            if (thisDate.isAfter(withdrawDate)) {
                return true;
            }
        }
        return false;
    }

    public void putPaymentAccount(double cash) {
        super.putPaymentAccount(cash);
    }
}

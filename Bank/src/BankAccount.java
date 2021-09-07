public class BankAccount {
    private double paymentAccount;

    public BankAccount() { }

    public void withdrawPaymentAccount(double cash) {
        if (isTransfer(cash)) {
            paymentAccount -= cash;
            System.out.println("Вы сняли со счёта: " + cash + "P.");
            infoPaymentAccount();
        }
        else {
            System.out.println("На счёте недостаточно средств!");
            infoPaymentAccount();
        }
    }
    public boolean isTransfer(double cash) {
        if (getPaymentAccount() >= cash) {
            return true;
        }
        else {
            return false;
        }
    }
    public void putPaymentAccount(double cash) {
        paymentAccount += cash;
        System.out.println("Сумма пополнения счёта: " + cash);
        infoPaymentAccount();
    }

    public void infoPaymentAccount() {
        System.out.println("Остаток на счёте: " + paymentAccount);
    }
    public double getPaymentAccount() {
        return paymentAccount;
    }

    public void transfer(BankAccount account, double amount) {
        account.paymentAccount -= account.feeCalc(amount);
        this.paymentAccount += amount;
        System.out.println("Сумма перевода: " + amount);
        account.infoPaymentAccount();
    }

    public boolean send(BankAccount receiver, double amount) {
        if (amount <= paymentAccount) {
            receiver.transfer(this, amount);
            return true;
        } else {
            System.out.println("Не достаточно средств!");
            infoPaymentAccount();
            return false;
        }
    }

    public double feeCalc(double cash) {
        return cash;
    }
}

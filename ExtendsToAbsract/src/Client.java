public abstract class рClient {
    private double bankAccount = 0;

    protected Client() { }

    public void putMoneyBankAccount(double money) {
        bankAccount += money;
        System.out.println("Счёт пополнен на сумму: " + money);
    }

    public void withdrawMoneyBankAccount(double money) {
        if (isWithdrawMoney()) {
            bankAccount -= money;
            System.out.println("Снятие наличных на сумму: " + money);
        }
        else {
            System.out.println("На счёте недостаточно средств!");
        }
    }

    public boolean isWithdrawMoney(double money) {
        if (getBankAccount() >= money) {
            return true;
        }
        else {
            return false;
        }
    }

    public double getBankAccount() {
        return bankAccount;
    }

    public void infoAccount();
}

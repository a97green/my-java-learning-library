public class IndividualEntrepreneur extends Client {
    public IndividualEntrepreneur() {
        super();
    }

    public void putMoneyBankAccount(double money) {
        double commission = 0;
        if (money >= 1000) {
            commission = feeOver(money);
        }
        else {
            commission = fee(money);
        }
        money -= commission;
        super.putMoneyBankAccount(money);
        System.out.println("Комиссия: " + commission);
    }

    public double feeOver(double money) {
        return (money * 0.5 / 100);
    }

    public double fee(double money) {
        return (money / 100);
    }

    public void infoAccount() {
        System.out.println("Индивидуальный предприниматель.");
        System.out.println("Пополнение: менее 1000 р. - комиссия 1%, свыше 1000 р. - 0.5%.");
        System.out.println("Снятие: без комиссии.");
        System.out.println("Баланс: " + getBankAccount() + " рублей.");
    }
}

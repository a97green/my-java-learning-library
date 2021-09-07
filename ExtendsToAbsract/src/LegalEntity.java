public class LegalEntity extends Client {
    public LegalEntity() {
        super();
    }

    @Override
    public void withdrawMoneyBankAccount(double money) {
        double commission = fee(money);
        money += commission;
        super.withdrawMoneyBankAccount(money);
        System.out.println("Из них комиссия составила: " + commission);
    }

    public double fee(double money) {
        return (money / 100);
    }

    public void infoAccount() {
        System.out.println("Юридическое лицо.");
        System.out.println("Пополнение: без комиссии.");
        System.out.println("Снятие наличных: комиссия - 1%.");
        System.out.println("Баланс: " + getBankAccount() + " рублей.");
    }
}

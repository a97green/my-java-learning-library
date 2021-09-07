public class CardBankAccount extends BankAccount {
    public CardBankAccount() {
        super();
    }

    @Override
    public void withdrawPaymentAccount(double cash) {
        if (isTransfer(cash)) {
            super.withdrawPaymentAccount(feeCalc(cash) + cash);
        }

    }

    public double feeCalc(double cash) {
        double fee = (cash / 100);
        System.out.println("Комиссия стоставила: " + fee);
        return fee + cash;
    }

    @Override
    public void putPaymentAccount(double cash) {
        super.putPaymentAccount(cash);
    }

}

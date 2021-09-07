public class NaturalPerson extends Client {
    public NaturalPerson() {
        super();
    }

    public void infoAccount() {
        System.out.println("Физическое лицо.");
        System.out.println("Баланс: " + getBankAccount() + " рублей.");
    }
}

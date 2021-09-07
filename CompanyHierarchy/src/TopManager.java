import java.text.DecimalFormat;

public class TopManager implements Employee {
    private static double SALARY = 30000;

    private double bonus;

    public TopManager(double companyIncome) {
        if (companyIncome >= 10000000) {
            bonus = SALARY * 1.5;
        }
        else {
            bonus = 0;
        }
    }

    public String toString() {
        String topManager = new DecimalFormat("#0.00").format(getMonthSalary());
        return "Топ Менеджер: " + topManager;
    }

    @Override
    public double getMonthSalary() {
        return SALARY + bonus;
    }
}

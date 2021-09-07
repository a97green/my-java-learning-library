import java.text.DecimalFormat;
import java.util.Random;

public class Manager implements Employee {
    private static double SALARY = 40000;

    private double percentageOfSales;

    public Manager() {
        Random generator = new Random();
        percentageOfSales = (115000 + (140000 - 115000) * generator.nextDouble()) * 0.05;
    }

    public String toString() {
        String manager = new DecimalFormat("#0.00").format(getMonthSalary());
        return "Менеджер: " + manager;
    }

    @Override
    public double getMonthSalary() {
        return SALARY + percentageOfSales;
    }
}

import java.text.DecimalFormat;

public class Operator implements Employee {
    private static double SALARY = 50000;

    public String toString() {
        String operator = new DecimalFormat("#0.00").format(getMonthSalary());
        return "Оператор: " + operator;
    }

    @Override
    public double getMonthSalary() {
        return SALARY;
    }
}

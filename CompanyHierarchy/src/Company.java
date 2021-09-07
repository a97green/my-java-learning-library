import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;
import java.util.TreeSet;

public class Company {
    private static double MIN_INCOME = 3000000;
    private static double MAX_INCOME = 20000000;

    private double companyIncome;

    private TreeSet<Employee> employees = new TreeSet<>(new EmployeeComparator());
    private ArrayList<Employee> employeesList = new ArrayList<>();


    public Company() {
        Random generatorIncome = new Random();
        companyIncome = MIN_INCOME + (MAX_INCOME - MIN_INCOME) * generatorIncome.nextDouble();
    }

    public ArrayList<Employee> getTopSalaryStaff(int count) {
        ArrayList<Employee> employeesTop = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            employeesTop.add(employeesList.get(i));
        }
        return employeesTop;
    }

    public ArrayList<Employee> getLowestSalaryStaff(int count) {
        ArrayList<Employee> employeesLowest = new ArrayList<>();
        for (int i = employees.size() - 1; count >= 0; i--, count--) {
            employeesLowest.add(employeesList.get(i));
        }
        return employeesLowest;
    }

    public void hire() {
        employees.add(employeeGenerator());
        employeesList.clear();
        employeesList.addAll(employees);
    }

    public void hireAll() {
        int numberOfEmployees = new Random().nextInt(100) + 100;
        for (int i = 0; i <= numberOfEmployees; i++) {
            employees.add(employeeGenerator());
        }
        employeesList.clear();
        employeesList.addAll(employees);
    }

    public void fire() {
        employees.remove(employees.size() - 1);
        employeesList.remove(employeesList.size() - 1);
    }

    public double getCompanyIncome() {
        return companyIncome;
    }

    public Employee employeeGenerator() {
        switch (new Random().nextInt(3)) {
            case 0: return new Manager();
            case 1: return new Operator();
            case 2: return new TopManager(getCompanyIncome());
        }
        return null;
    }

    public void printCompanyInformation() {
        String income = new DecimalFormat("#0.00").format(getCompanyIncome());
        System.out.println("Бюджет компании: " + income);
        System.out.println("Количество сотрудников: " + employeesList.size());
        System.out.println("Топовые сотрудники:");
        for (Employee employee : getTopSalaryStaff(15)) {
            System.out.println(employee);
        }
        System.out.println("Не опытные сотрудники:");
        for (Employee employee : getLowestSalaryStaff(15)) {
            System.out.println(employee);
        }
    }

}

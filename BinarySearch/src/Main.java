import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        CarNumberGenerator generator = new CarNumberGenerator();
        ArrayList<String> carNumbers = generator.generateCarNumber();

        TreeSet<String> carNumbersTree = new TreeSet<>();
        carNumbersTree.addAll(carNumbers);

        HashSet<String> carNumbersHash = new HashSet<>();
        carNumbersHash.addAll(carNumbers);

        while(true) {
            System.out.print("Введите номер автомобиля: ");
            String numberCar = scanner.nextLine();

            long start = System.currentTimeMillis();
            if (carNumbersHash.contains(numberCar)) {
                long duration = System.currentTimeMillis();
                System.out.println("HashSet поиск. Номер: " + numberCar + " найден!");
                System.out.println("Время выполнения: " + (duration - start) + "мс.");

                start = System.currentTimeMillis();
            }
            if (carNumbersTree.contains(numberCar)) {
                long duration = System.currentTimeMillis();
                System.out.println("TreeSet поиск. Номер: " + numberCar + " найден!");
                System.out.println("Время выполнения: " + (duration - start) + "мс.");

                start = System.currentTimeMillis();
            }
            if (carNumbers.contains(numberCar)) {
                long duration = System.currentTimeMillis();
                System.out.println("Обычный поиск. Номер: " + numberCar + " найден!");
                System.out.println("Время выполнения: " + (duration - start) + "мс.");

                Collections.sort(carNumbers);
                start = System.currentTimeMillis();
            }
            if (Collections.binarySearch(carNumbers, numberCar) >= 0) {
                long duration = System.currentTimeMillis();
                System.out.println("Бинарный поиск. Номер: " + numberCar + " найден!");
                System.out.println("Время выполнения: " + (duration - start) + "мс.");
            }
            else {
                System.out.println("Номер не найден!");
            }
        }
    }
}

import java.util.ArrayList;

public class CarNumberGenerator {
    private static int MAX_NUMBER_REGION = 197;
    private static int MAX_CAR_NUMBER = 9;

    private ArrayList<String> carNumbers = new ArrayList<>();

    private ArrayList<String> chars = new ArrayList<>() {{
        add("A");
        add("B");
        add("C");
        add("E");
        add("H");
        add("K");
        add("M");
        add("O");
        add("P");
        add("T");
        add("Y");
        add("X");
    }};

    public ArrayList<String> generateCarNumber() {
        for (int region = 1; region <= MAX_NUMBER_REGION; region++) {
            for (int firstCharNumber = 0; firstCharNumber < chars.size(); firstCharNumber++) {
                String fistChar = chars.get(firstCharNumber);
                for (int lastOneCharNumber = 0; lastOneCharNumber < chars.size(); lastOneCharNumber++) {
                    String lastOneChar = chars.get(lastOneCharNumber);
                    for (int lastTwoCharNumber = 0; lastTwoCharNumber < chars.size(); lastTwoCharNumber++) {
                        String lastTwoChar = chars.get(lastTwoCharNumber);
                        for (int carNumber = 0; carNumber <= 9; carNumber++) {
                            String numberCar = Integer.toString(carNumber);
                            String number = (numberCar + numberCar + numberCar);
                            carNumbers.add(fistChar + number + lastOneChar + lastTwoChar /*+ " | "*/ + region);
                        }
                    }
                }
            }
        }
        return carNumbers;
    }
}

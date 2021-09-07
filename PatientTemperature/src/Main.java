import java.util.Random;

public class Main {
    private static double MAX_NORMAL_TEMPERATURE = 36.9;
    private static double MIN_NORMAL_TEMPERATURE = 36.2;
   // private static double MAX_TEMPERATURE = 40.0;
   // private static double MIN_TEMPERATURE = 32.0;
    private static int PATIENT_NUMBER = 30;

    public static void main(String[] args) {
        Random random = new Random();

        double mediumTemperature = 0.0;
        int numberOfHealthyPatients = 0;

        double[] patientTemperature = new double[PATIENT_NUMBER];

        for (int i = 0; i < patientTemperature.length; i++) {
            patientTemperature[i] = (random.nextDouble() + 4) * 8;
            mediumTemperature += patientTemperature[i];

            if (MIN_NORMAL_TEMPERATURE <= patientTemperature[i] &&
                    patientTemperature[i] <= MAX_NORMAL_TEMPERATURE) {
                numberOfHealthyPatients++;
            }
            System.out.println("Пациент №: " + i + " температура: " + patientTemperature[i]);
        }
        System.out.println("Средняя температура всех пациентов: " + (mediumTemperature / patientTemperature.length));
        System.out.println("Колличество здоровых пациентов: " + numberOfHealthyPatients);
    }
}

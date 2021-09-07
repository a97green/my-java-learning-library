public class Main {
    public static void main(String[] args) {
        String text = "Каждый охотник желает знать, где сидит фазан";
        String resultTextColors = "Colors: \n";
        String resultTextReColors = "ReColors: \n";

        String[] colors = text.split(",?\\s+");
        String[] reColors = new String[colors.length];

        int j = 0;

        for (int i = colors.length - 1; i >= 0; i--) {
            reColors[j++] = colors[i];
        }
        for (int i = 0; i < colors.length; i++) {
            resultTextColors += colors[i] + "\n";
            resultTextReColors += reColors[i] + "\n";
        }
        System.out.println(resultTextColors);
        System.out.println(resultTextReColors);
    }
}

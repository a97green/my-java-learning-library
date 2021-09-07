public class Main {
    public static void main(String[] args) {
        char[][] shape = new char[7][7];
        char x = 'X';
        int firstIndex = 0;
        int lastIndex = 6;
        for (int i = 0; i < shape.length; i++) {
            for (int j = 0; j < shape[i].length; j++) {
                shape[i][j] = ' ';
            }
        }
        for (int i = 0; i < shape.length; i++) {
            shape[i][firstIndex++] = x;
            shape[i][lastIndex--] = x;
        }
        for (char[] firstShape : shape) {
            System.out.println();
            for (char lastShape : firstShape)
                System.out.print(lastShape);
        }
    }
}

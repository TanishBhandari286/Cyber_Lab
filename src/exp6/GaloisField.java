package exp6;

public class GaloisField {

    public static void main(String[] args) {
        int[] GF8_elements = {0, 1, 2, 3, 4, 5, 6, 7};
        System.out.println("Addition Table:");
        printAdditionTable(GF8_elements);
        System.out.println("Multiplication Table:");
        printMultiplicationTable(GF8_elements);
    }
    public static void printAdditionTable(int[] arr) {
        int[][] table = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = (arr[i] + arr[j]) % 8;
            }
        }
        printTable(table, arr);
    }
    public static void printMultiplicationTable(int[] arr) {
        int[][] table = new int[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                table[i][j] = (arr[i] * arr[j]) % 8;
            }
        }
        printTable(table, arr);
    }
    public static void printTable(int[][] table, int[] arr) {
        // Print header row
        for (int elem : arr) {
            System.out.print(elem + " ");
        }
        System.out.println();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
    }

}
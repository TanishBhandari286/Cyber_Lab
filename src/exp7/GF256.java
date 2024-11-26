package exp7;
import java.util.Arrays;

public class GF256 {
    private static final int IRREDUCIBLE_POLYNOMIAL = 0x11B;
    private static final int FIELD_SIZE = 256;
    private static int[] expTable = new int[FIELD_SIZE];
    private static int[] logTable = new int[FIELD_SIZE];
    private static int[] elements = new int[FIELD_SIZE];

    public static void main(String[] args) {
        generateField();

        System.out.println("Elements as vectors:");
        for (int i = 0; i < FIELD_SIZE; i++) {
            System.out.printf("%3d: %s%n", i, toBinaryString(elements[i]));
        }

        System.out.println("\nElements as powers of the generator (α):");
        for (int i = 1; i < FIELD_SIZE; i++) {
            System.out.printf("α^%d: %s%n", logTable[i], toBinaryString(elements[i]));
        }

        int a = 0x53;
        int b = 0xCA;

        int addResult = add(a, b);
        int mulResult = multiply(a, b);

        System.out.println("\nAddition and Multiplication:");
        System.out.printf("Addition of %s and %s: %s%n", toBinaryString(a), toBinaryString(b), toBinaryString(addResult));
        System.out.printf("Multiplication of %s and %s: %s%n", toBinaryString(a), toBinaryString(b), toBinaryString(mulResult));
    }


    private static void generateField() {
        int generator = 1;
        for (int i = 0; i < FIELD_SIZE; i++) {
            expTable[i] = generator;
            logTable[generator] = i;
            elements[i] = generator;

            generator <<= 1;
            if ((generator & FIELD_SIZE) != 0) {
                generator ^= IRREDUCIBLE_POLYNOMIAL;
            }
        }
        expTable[FIELD_SIZE - 1] = 1;
    }

    private static int add(int a, int b) {
        return a ^ b;
    }

    private static int multiply(int a, int b) {
        if (a == 0 || b == 0) return 0;
        int logA = logTable[a];
        int logB = logTable[b];
        int logResult = (logA + logB) % (FIELD_SIZE - 1);
        return expTable[logResult];
    }

    private static String toBinaryString(int value) {
        return String.format("%8s", Integer.toBinaryString(value)).replace(' ', '0');
    }
}

package exp1;

import java.util.Scanner;

public class Gcd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter two numbers a and b: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int gcd_value = gcd(a, b);
        System.out.println("GCD(" + a + ", " + b + ") = " + gcd_value);
    }
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

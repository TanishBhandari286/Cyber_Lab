package exp2;
import java.util.Scanner;
public class Multiplicative_Inverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter value of b: ");
        int b = scanner.nextInt();
        System.out.print("Enter value of p (prime number): ");
        int p = scanner.nextInt();
        int t = 0, newT = 1;
        int r = p, newR = b;
        while (newR != 0) {
            int quotient = r / newR;
            int tempT = t;
            t = newT;
            newT = tempT - quotient * newT;
            int tempR = r;
            r = newR;
            newR = tempR - quotient * newR;
        }
        if (r > 1) {
            System.out.println(b + " does not have a multiplicative inverse in Z" + p);
        } else {
            if (t < 0) {
                t = t + p;
            }
            System.out.println("Multiplicative Inverse of " + b + " in Z" + p + " is: " + t);
        }
    }
}

package exp3;
import java.util.Scanner;
public class Multiplicative_Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the string:");
        String input = scanner.nextLine();
        System.out.println("Enter the key:");
        int key = scanner.nextInt();
        if (gcd(key, 26) != 1) {
            System.out.println("Invalid key!");
        }
        else{
            String ciphertext = "";

            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch >= 'a' && ch <= 'z') {
                    char answer = (char) ((ch - 'a') * key % 26);
                    answer = (char) (answer+ 'a');
                    ciphertext = ciphertext + answer;
                }
            }
            System.out.println("Ciper: " + ciphertext);
        }
    }
    private static int gcd(int a, int b) {
        while (b != 0) {
            b = a % b;
        }
        return a;
    }
}



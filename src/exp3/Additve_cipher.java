package exp3;
import java.util.Scanner;
public class Additve_cipher {

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the text to be encrypted:");
            String input = scanner.nextLine();
            System.out.print("Enter the key value:");
            int key = scanner.nextInt();
            String cipherText = "";
            for (int i = 0; i < input.length(); i++) {
                char c = input.charAt(i);
                if (c >= 'a' && c <= 'z') {
                    c = (char) ((c - 'a' + key) % 26);
                    c = (char) (c+ 'a');
                }
                cipherText = cipherText + c;
            }
            System.out.println("Answer: " + cipherText);

        }
    }


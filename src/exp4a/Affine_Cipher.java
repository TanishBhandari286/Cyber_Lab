package exp4a;
import java.util.Scanner;
public class Affine_Cipher {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the message
        System.out.print("Enter the message to encrypt: ");
        String message = scanner.nextLine();
        int a = 7;
        int b = 1;
        String encryptedMessage = "";
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            if (Character.isLetter(ch)) {
                int x = Character.toLowerCase(ch) - 'a';
                int encryptedChar = (a * x + b) % 26;
                char encryptedCharResult = (char) (encryptedChar + 'a');
                if (Character.isUpperCase(ch)) {
                    encryptedCharResult = Character.toUpperCase(encryptedCharResult);
                }
                encryptedMessage += encryptedCharResult;
            } else {
                encryptedMessage += ch;
            }
        }

        System.out.println("Encrypted Message: " + encryptedMessage);
        String decryptedMessage = "";
        for (int i = 0; i < encryptedMessage.length(); i++) {
            char ch = encryptedMessage.charAt(i);
            if (Character.isLetter(ch)) {
                int y = Character.toLowerCase(ch) - 'a';
                int a_inverse = 15;
                int decryptedChar = (a_inverse * (y - b + 26)) % 26;
                char decryptedCharResult = (char) (decryptedChar + 'a');
                if (Character.isUpperCase(ch)) {
                    decryptedCharResult = Character.toUpperCase(decryptedCharResult);
                }
                decryptedMessage += decryptedCharResult;
            } else {
                decryptedMessage += ch;
            }
        }
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}

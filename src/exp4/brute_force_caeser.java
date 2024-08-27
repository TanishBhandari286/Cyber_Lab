package exp4;

import java.util.Arrays;

public class brute_force_caeser {
    public static void main(String[] args) {
        String text = "It is good to be talkative";
        int encryptionKey = 3;
        char[] encryptedText = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                encryptedText[i] = (char) ((ch - 'a' + encryptionKey) % 26 + 'a');
            }
        }
        System.out.println("Plain Text: " + text);
        System.out.println("Encrypted Text: " + new String(encryptedText));
        System.out.println("\nBrute-force decryption results:");
        char[] decryptedText = new char[encryptedText.length];
        for (int key = 1; key <= 26; key++) {
            for (int i = 0; i < encryptedText.length; i++) {
                char ch = encryptedText[i];
                if (ch >= 'a' && ch <= 'z') {
                    decryptedText[i] = (char) ((ch - 'a' - key + 26) % 26 + 'a');
                }
            }
            System.out.println("Key" + key  + " " + new String(decryptedText));
        }
    }
}

package exp4;
import java.util.*;

public class caesercipher {
    public static void main(String[] args) {
        String text = "It is good to be talkative";
        int shift = 3;
        char[] cipherText = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            cipherText[i] = (char) ((ch - 'a' + shift) % 26 + 'a');
        }
        System.out.println("Plain Text: " + text);
        System.out.println("Cipher Text: " + Arrays.toString(cipherText));
    }
}

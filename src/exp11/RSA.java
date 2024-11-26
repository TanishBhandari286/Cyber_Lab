package exp11;
import java.math.BigInteger;
import java.util.Random;

public class RSA {
    private BigInteger n, e, d;
    private int bitLength = 512;

    public RSA() {
        generateKeys();
    }

    private void generateKeys() {
        Random rand = new Random();
        BigInteger p = BigInteger.probablePrime(bitLength / 2, rand);
        BigInteger q = BigInteger.probablePrime(bitLength / 2, rand);

        n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        e = BigInteger.valueOf(65537);
        d = e.modInverse(phi);
    }

    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger encrypted) {
        return encrypted.modPow(d, n);
    }

    public static void main(String[] args) {
        RSA rsa = new RSA();

        System.out.println("Public Key (n, e):");
        System.out.println("n: " + rsa.n);
        System.out.println("e: " + rsa.e);

        System.out.println("\nPrivate Key (n, d):");
        System.out.println("d: " + rsa.d);

        String message = "HELLO";
        System.out.println("\nOriginal Message: " + message);

        BigInteger messageNumber = new BigInteger(message.getBytes());
        System.out.println("Message as number: " + messageNumber);

        BigInteger encrypted = rsa.encrypt(messageNumber);
        System.out.println("Encrypted message: " + encrypted);

        BigInteger decrypted = rsa.decrypt(encrypted);
        System.out.println("Decrypted message as number: " + decrypted);

        String decryptedMessage = new String(decrypted.toByteArray());
        System.out.println("Decrypted Message: " + decryptedMessage);
    }
}

package data_structures_and_algorithms_in_Java_6th.chapter3_fundamental_data_structures.simple_cryptography_with_character_arrays;

/**
 * Class for doing encryption and decryption using the Caesar Cipher
 */
public class CaesarCipher {

    protected char[] encoder = new char[26];    // Encryption array
    protected char[] decoder = new char[26];    // Decryption array

    /**
     * Constructor that initializes the encryption and decryption arrays
     * @param rotation
     */
    public CaesarCipher(int rotation) {
        for (int i = 0; i < 26; i++) {
            encoder[i] = (char) ('A' + (i + rotation) % 26);
            decoder[i] = (char) ('A' + (i - rotation + 26) % 26);
        }
    }

    /**
     * Returns String representing encrypted message.
     * @param message   Message
     * @return          Encrypted message
     */
    public String encrypt(String message) {
        return transform(message, encoder);     // Use encoder array
    }


    /**
     * Returns String representing decrypted message.
     * @param message   Message
     * @return          Decrypted message
     */
    public String decrypt(String message) {
        return transform(message, encoder);     // Use encoder array
    }

    /**
     * Returns transformation of original String using given code.
     * @param original  Message original
     * @param code      Code arrays
     * @return          Message transformed
     */
    private String transform(String original, char[] code) {
        char[] msg = original.toCharArray();
        for (int k = 0; k < msg.length; k++)
            if (Character.isUpperCase(msg[k])) {    // We have a letter to change
                int j = msg[k] - 'A';               // Will be value from 0 to 25
                msg[k] = code[j];                   // Replace the character
            }
        return new String(msg);
    }


    /**
     * Simple main method for testing the Caesar cipher
     * @param args  args
     */
    public static void main(String[ ] args) {
        CaesarCipher cipher = new CaesarCipher(3);
        System.out.println("Encryption code = " + new String(cipher.encoder));
        System.out.println("Decryption code = " + new String(cipher.decoder));
        String message = "THE EAGLE IS IN PLAY; MEET AT JOE'S.";
        String coded = cipher.encrypt(message);
        System.out.println("Secret: " + coded);
        String answer = cipher.decrypt(coded);
        System.out.println("Message: " + answer);// should be plaintext again
    }


}

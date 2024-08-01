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


}

import java.util.Locale;
import java.util.Scanner;

public class Main {
    Scanner in = new Scanner(System.in);

    void askForText(){
        System.out.println("Please enter text for encryption: ");
    }
    void askForShift(){
        System.out.println("Please enter shifting number for encryption (1-29) : ");
    }

    int[] stringToIntConverter(String text) {
        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String uppercasedString = text.toUpperCase(Locale.ROOT);
        int[] convertedString = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {

            convertedString[i] = alphabet.indexOf(uppercasedString.charAt(i));
        }
        return convertedString;
    }

    String intToEncryption(int shift, int[] convertedString) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String encryptedMessage = "";
        for (int i = 0; i < convertedString.length; i++) {
            if (convertedString[i] == 0)  {
                encryptedMessage += " ";
            }
            else {
                encryptedMessage += (alphabet.charAt(((convertedString[i] + shift ) - 1) % 29));
            }
        }
        return encryptedMessage;
    }

    String intToDecryption(int shift, int[] convertedString) {
        String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String decryptedMessage = "";
        for (int i = 0; i < convertedString.length; i++) {
            if (convertedString[i] == 0)  {
                decryptedMessage += " ";
            }
            else if ((convertedString[i] - shift - 1) < 0) {
                decryptedMessage += alphabet.charAt((convertedString[i] - shift) + alphabet.length() - 1);
            }
            else {
                decryptedMessage += alphabet.charAt(((convertedString[i] - shift ) - 1 ) % 29 ) ;
            }
        }
        return decryptedMessage;
    }

    public static void main(String[] args) {
        Main method = new Main();
        Scanner in = new Scanner(System.in);

        // Ask user for text and takes input
        method.askForText();
        String textToBeEncrypted = in.nextLine();

        // Ask user for shift and take (int) input
        method.askForShift();
        int shift = in.nextInt();

        String postEncryptionMessage = method.intToEncryption(shift, method.stringToIntConverter(textToBeEncrypted));
        System.out.println("Your encrypted message is: \n" + postEncryptionMessage);

        // Decryption test below
        String postDecryptionMessage = method.intToDecryption(shift, method.stringToIntConverter(postEncryptionMessage));

        System.out.println("Test of post encryption message in the decryption method: ");
        System.out.println(postDecryptionMessage);

    }
}

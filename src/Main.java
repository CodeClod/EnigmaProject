import java.util.Locale;
import java.util.Scanner;

public class Main {

    void askForText(){
        System.out.println("Please enter text for encryption: ");
    }

    void askForInt(){
        System.out.println("Please enter shifting number for encryption: ");
    }

    int[] stringToIntConverter(String text) {
        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";
        String uppercasedString = text.toUpperCase(Locale.ROOT);
        int[] convertedString = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {

            convertedString[i] = alphabet.indexOf(text.charAt(i));
        }
        return convertedString;
    }

    String intToEncryption(int shift, int[] convertedString) {
        String alphabet = " ABCDEFGHIJKLMNOPQRSTUVWXYZÆØÅ";

        for (int i = 0; i < convertedString.length; i++) {
            if (convertedString[i] == 0) {

            }
            convertedString[i] = alphabet.indexOf(text.charAt(i));
        }
    }


    public static void main(String[] args) {
        Main method = new Main();

        method.askForText();


        method.askForInt();



        Scanner in = new Scanner(System.in);
    }
}

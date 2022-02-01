import java.util.Scanner;

public class Panagram {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the string: ");
        String sentence = input.next();
        System.out.println("Is Panagram? " + checkIfPangram(sentence));
    }

    public static boolean checkIfPangram(String sentence) {
        int len = sentence.length();
        if(len < 26) {
            return false;
        }

        int[] alphabets = new int[26];
        int count = 0;
        for (int i = 0; i < len; i++) {
            int temp = sentence.charAt(i) - 97;
            if(alphabets[temp] != 1) {
                count += 1;
                alphabets[temp] = 1;
            }
        }
        return count == 26;
    }
}

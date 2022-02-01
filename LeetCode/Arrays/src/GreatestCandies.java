import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class GreatestCandies {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter length of array: ");
        int len = input.nextInt();
        int[] arr = new int[len];
        System.out.print("Enter elements of array: ");
        for (int i = 0; i < len; i++) {
            arr[i] = input.nextInt();
        }

        System.out.print("Enter number of extra candies: ");
        int extraCandies = input.nextInt();

        System.out.println("Input array: " + Arrays.toString(arr));
        System.out.println("Extra Candies: " + extraCandies);
        System.out.println("Output Array: " + kidsWithCandies(arr, extraCandies));
    }

    public static List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;
        int len = candies.length;
        ArrayList<Boolean> list  = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if(candies[i] > max) {
                max = candies[i];
            }
            candies[i] += extraCandies;
        }

        for (int i = 0; i < len; i++) {
            if(candies[i] >= max) {
                list.add(true);
            }
            else {
                list.add(false);
            }
        }
        return list;
    }
}

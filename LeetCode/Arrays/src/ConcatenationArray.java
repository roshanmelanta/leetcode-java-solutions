import java.util.Arrays;
import java.util.Scanner;

public class ConcatenationArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int len = input.nextInt();

        System.out.print("Enter Number: ");
        int[] arr = new int[len];
        for(int i = 0; i < len; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Concatenated Array: " + Arrays.toString(getConcatenation(arr)));
    }

    public static int[] getConcatenation(int[] nums){
        int len = (nums.length)*2;
        int[] ans = new int[len];
        for (int i = 0; i < len; i++) {
            ans[i] = nums[i%(len/2)];
        }
        return ans;
    }
}

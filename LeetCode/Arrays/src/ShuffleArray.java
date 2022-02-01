import java.util.Arrays;
import java.util.Scanner;

public class ShuffleArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int len = input.nextInt();
        int[] arr = new int[len];

        System.out.print("Enter elements: ");
        for (int i = 0; i < len; i++) {
            arr[i] = input.nextInt();
        }

        System.out.println("Input Array: " + Arrays.toString(arr));
        System.out.println("Output Array: " + Arrays.toString(shuffle(arr)));
    }

    public static int[] shuffle(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        int n = len/2;

        int count = 0;
        int i = 0;

        while(count != n) {
            res[i] = nums[count];
            res[i+1] = nums[count+n];
            count += 1;
            i += 2;
        }
        return res;
    }
}

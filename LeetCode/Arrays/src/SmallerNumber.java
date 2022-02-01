import java.util.Arrays;
import java.util.Scanner;

public class SmallerNumber {
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
        System.out.println("Output Array: " + Arrays.toString(smallerNumbersThanCurrent(arr)));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];

        for (int i = 0; i < len; i++) {
            int count = 0;
            for (int j = 0; j < len; j++) {
                if(nums[i] > nums[j]) {
                    count += 1;
                }
            }
            res[i] = count;
        }
        return res;
    }
}

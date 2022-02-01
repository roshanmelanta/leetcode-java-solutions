import java.util.Arrays;
import java.util.Scanner;

public class BuildArrayPermutation {
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
        System.out.println("Built Array: " + Arrays.toString(buildArray(arr)));

    }

    public static int[] buildArray(int[] nums) {
        int len = nums.length;

        int[] res = new int[len];
        for(int i = 0; i < len; i++) {
            res[i] = nums[nums[i]];
        }
        return res;
    }
}

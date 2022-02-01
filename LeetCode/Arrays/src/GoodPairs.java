import java.util.Arrays;
import java.util.Scanner;

public class GoodPairs {
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
        System.out.println("Number of Good Pairs: " + numIdenticalPairs(arr));
    }

    public static int numIdenticalPairs(int[] nums) {
        int len = nums.length;
        int count = 0;
        for (int i = 0; i < len-1; i++) {
            for (int j = i+1; j < len; j++) {
                if(nums[i] == nums[j]) {
                    count += 1;
                }
            }
        }
        return count;
    }
}

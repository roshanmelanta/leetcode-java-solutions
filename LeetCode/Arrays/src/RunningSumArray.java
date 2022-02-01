import java.util.Arrays;
import java.util.Scanner;

public class RunningSumArray {
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
        System.out.println("Built Array: " + Arrays.toString(runningSum(arr)));
    }

    public static int[] runningSum(int[] nums){
        int n = nums.length;
        int sum = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            sum = sum + nums[i];
            ans[i] = sum;
        }
        return ans;
    }
}

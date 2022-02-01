import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class TargetArray {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter length of array: ");
        int len = input.nextInt();

        int[] nums = new int[len];
        System.out.print("Enter elements in nums array: ");
        for (int i = 0; i < len; i++) {
            nums[i] = input.nextInt();
        }

        int[] index = new int[len];
        System.out.print("Enter elements in index array: ");
        for (int i = 0; i < len; i++) {
            index[i] = input.nextInt();
        }

        System.out.println("Nums Array: " + Arrays.toString(nums));
        System.out.println("Index Array: " + Arrays.toString(index));
        System.out.println("Target Array: " + Arrays.toString(createTargetArray(nums,index)));
    }

    public static int[] createTargetArray(int[] nums, int[] index) {
        int len = nums.length;
        int[] target = new int[len];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            list.add(index[i], nums[i]);
        }
        for (int i = 0; i < len; i++) {
            target[i] = list.get(i);
        }
        return target;
    }
}

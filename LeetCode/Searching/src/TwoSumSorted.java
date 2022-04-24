import java.util.Arrays;

public class TwoSumSorted {
    public static void main(String[] args) {
        int[] arr = {2,7,11,15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(arr,target)));
    }
    // https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    public static int[] twoSum(int[] numbers, int target) {
        int a_pointer = 0;
        int b_pointer = numbers.length - 1;

        while (a_pointer < b_pointer) {
            int sum = numbers[a_pointer] + numbers[b_pointer];

            if (sum > target) {
                b_pointer -= 1;
            }
            else if (sum < target) {
                a_pointer += 1;
            }
            else {
                return new int[]{a_pointer+1, b_pointer+1};
            }
        }
        return new int[]{-1,-1};
    }
}

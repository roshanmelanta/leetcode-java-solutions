import java.util.Arrays;

public class ArrayPartition1 {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums); // sort array for iteration
        int sum = 0;
        // Increment i by 2 cause subarray has to have 2 elements
        for (int i = 0; i < nums.length - 1; i += 2) {
            // sum of first element/minimum element will be stored
            sum += nums[i];
        }
        return sum;
    }
}

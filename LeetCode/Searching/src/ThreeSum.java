import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {
    // https://leetcode.com/problems/3sum/
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums); // sort the array for two pointers
        List<List<Integer>> output_arr = new LinkedList<>();

        // Consider each element of array as first element of triplets and find the other two by two pointers method
        for (int i = 0; i < nums.length - 2; i++) {
            if (i == 0 || nums[i] != nums[i - 1]) {
                int low = i + 1;
                int high = nums.length - 1;
                int sum = 0 - nums[i];

                // Standard bi-directional 2Sum sweep of the remaining part of the array
                while (low < high) {
                    if (nums[low] + nums[high] == sum) {
                        output_arr.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low + 1]) low++;
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        low++;
                        high--;
                    }
                    else if (nums[low] + nums[high] > sum) {
                        high--;
                    }
                    else {
                        low++;
                    }
                }
            }
        }
        return output_arr;
    }
}

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2};
        int target = 0;
        List<List<Integer>> output = fourSum(nums, target);
        for (List n : output) {
            System.out.println(n);
        }
    }

    // https://leetcode.com/problems/4sum/
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new LinkedList<>();
        int n = nums.length;

        // For the first element in quadruplet
        for (int i = 0; i < n; i++) {
            // Nested for loop for second element in quadruplet
            for (int j = i + 1; j < n; j++) {
                int low = j + 1; // for
                int high = n - 1;
                int sum = nums[i] + nums[j];
                int target_2 = target - sum;

                // Standard bidirectional 2Sum sweep of the remaining part of the array
                while (low < high) {
                    if (nums[low] + nums[high] == target_2) {
                        res.add(Arrays.asList(nums[low], nums[high], nums[i], nums[j]));

                        while (low < high && nums[low] == nums[low + 1]) low++; // check if next low is duplicate
                        while (low < high && nums[high] == nums[high - 1]) high--; // check if next high is duplicate

                        // normal shift of low and high after each operation
                        low++;
                        high--;
                    } else if (nums[low] + nums[high] > target_2) {
                        high--;
                    } else {
                        low++;
                    }
                }
                // check if next element is duplicate for j
                while (j + 1 < n && nums[j] == nums[j + 1]) ++j;
            }
            // check if next element is duplicate for i
            while (i + 1 < n && nums[i] == nums[i + 1]) ++i;
        }
        return res;
    }
}

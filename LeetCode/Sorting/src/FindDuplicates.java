import java.util.List;

public class FindDuplicates {
    // https://leetcode.com/problems/find-the-duplicate-number/submissions/
    public int findDuplicate(int[] nums) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] != i + 1) {
                int correctIndex = nums[i] - 1;
                if (nums[i] != nums[correctIndex]) {
                    swap(nums, i, correctIndex);
                }
                else {
                    return nums[i];
                }
            }
            else {
                i++;
            }
        }
        return -1;
    }

    public void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

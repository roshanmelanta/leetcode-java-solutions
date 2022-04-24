import java.util.Arrays;

// (34. Find First and Last Position of Element in Sorted Array)[https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/submissions/]

public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] nums = {2,7,7,7,7,8,8,9};
        int target = 7;
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1,-1};
        // check for first occurrence if target first
        ans[0] = search(nums, target, true);
        if(ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }

    public static int search(int[] nums, int target, boolean findStartIndex) {
        int ans = -1;
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < nums[mid]) {
                end = mid - 1;
            }
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            else {
                // potential answer found
                ans = mid;
                if(findStartIndex) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return ans;
    }
}

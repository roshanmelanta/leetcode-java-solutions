public class SearchInsertPosition {
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,7};
        int target = 1;
        System.out.println(searchInsert(arr, target));
    }

    // https://leetcode.com/problems/search-insert-position/
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return start;
    }
}

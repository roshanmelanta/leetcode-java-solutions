public class MinimumRotatedArray2 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3};
        int a[] = nums1;
        double  b = Double.POSITIVE_INFINITY;
        double c= Double.NEGATIVE_INFINITY;
    }
    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
    public int findMin(int[] nums) {
        int pivot = findPivot(nums);
        if (pivot < nums.length - 1) {
            return nums[pivot + 1];
        }
        else {
            return nums[0];
        }
    }

    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid + 1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            }

            // if elements at middle, start, end are equal then just skip the duplicates
            if (arr[mid] == arr[start] && arr[mid] == arr[end]) {
                // skip the duplicates
                // NOTE: what if these elements at start and end were the pivot??
                // check if start is pivot
                if (start < end && arr[start] > arr[start + 1]) {
                    return start;
                }
                start++;

                // check whether end is pivot
                if (end > start && arr[end] < arr[end - 1]) {
                    return end - 1;
                }
                end--;
            }
            // left side is sorted, so pivot should be in right
            else if (arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }
}

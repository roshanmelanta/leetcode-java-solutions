import java.util.Arrays;

public class MinAbsSumDiff {
    public static void main(String[] args) {
        int[] nums1 = {8,9,2};
        int[] nums2 = {7,7,3};
        System.out.println(minAbsoluteSumDiff(nums1, nums2));
    }

    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        long orgDiff = 0;
        long n = nums1.length;
        long minDiff;

        // Calculating the original difference without any replacement
        for (int i = 0; i < n; i++) {
            orgDiff += Math.abs(nums1[i] - nums2[i]);
        }
        minDiff = orgDiff;

        // Sorted nums1 needed for binary search
        int[] arr = nums1.clone();
        Arrays.sort(arr);

        // Find new difference after replacement
        for (int i = 0; i < n; i++) {
            long newDiff = Math.abs(orgDiff - Math.abs(nums1[i] - nums2[i]) + Math.abs(binarySearch(arr, nums2[i]) - nums2[i]));
            // minDiff will store minimum possible sum of difference after replacements
            minDiff = Math.min(minDiff, newDiff);
        }
        return (int)minDiff % 1_000_000_007;

    }

    public static int binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;
        int closest;
        int mid = 0;

        while (start <= end) {
            mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            }
            if (arr[mid] > target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        closest = arr[mid];

        // lower bound will return us either equal to or next greater number in sorted array.
        // But it might not be the closest one.
        // That's why we also need to check the number previous to the one returned by lower_bound which may be closer to nums2[i].
        if (mid - 1 >= 0 && Math.abs(arr[mid - 1] - target) < Math.abs(arr[mid] - target)) {
            closest = arr[mid - 1];
        }
        if (mid + 1 < arr.length && Math.abs(arr[mid + 1] - target) < Math.abs(arr[mid] - target)) {
            closest = arr[mid + 1];
        }
        System.out.println(closest);
        return closest;
    }
}

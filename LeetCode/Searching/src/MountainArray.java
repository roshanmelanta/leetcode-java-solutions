public class MountainArray {

    // https://leetcode.com/problems/find-in-mountain-array/
    public static int search(int target, int[] arr) {
        int peak = peakIndexInMountainArray(arr);
        int firstTry = orderAgnosticBS(arr,target, 0, peak);
        if (firstTry != -1) {
            return firstTry;
        }
        return orderAgnosticBS(arr, target, peak+1, arr.length-1);
    }

    public static int orderAgnosticBS(int[] arr, int target, int start, int end) {

        // find whether array is sorted in ascending or descending
        boolean isAsc = arr[start] < arr[end];

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return mid;
            }

            if (isAsc) {
                if (target < arr[mid]) {
                    end = mid -1;
                }
                else {
                    start = mid + 1;
                }
            }
            else {
                if (target > arr[mid]) {
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start < end) {
            int mid = start + (end - start)/2;

            if (arr[mid] > arr[mid + 1]) {
                // you are in descending part of array
                // this may be the ans, but look at left
                // this is why end != mid - 1
                end = mid;
            }
            else {
                // you are in ascending part of the array
                start = mid + 1; // because we know that mid+1 element > mid element
            }
        }
        return start; // or return end
    }
}

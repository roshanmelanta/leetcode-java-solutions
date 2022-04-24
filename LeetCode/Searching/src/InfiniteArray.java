// https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/

public class InfiniteArray {
    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 10;
        System.out.println(ans(arr, target));
    }

    static int ans(int[] nums, int target) {
        // first find the range
        // first start with box of size 2
        int start = 0;
        int end = 1;

        while(target > nums[end]) {
            int temp = end + 1; // new start
            // double the subarray value
            // end = previousEnd + sizeOfBox * 2
            end = end + (end - start + 1) * 2;
            start = temp; // want to use old start above, hence update start later
        }

        return floor(nums, target, start, end);
    }


    static int floor(int[] arr, int target, int start, int end) {
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            } else if (target > arr[mid]) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

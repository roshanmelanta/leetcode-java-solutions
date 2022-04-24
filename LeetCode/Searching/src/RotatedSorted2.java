public class RotatedSorted2 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,1,1,1};
        int target = 1;
        System.out.println(findPivot(nums));
        System.out.println(search(nums, target));
    }

    // https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
//    public static boolean search(int[] nums, int target) {
//        int pivot = findPivot(nums);
//
//        if (pivot == -1) {
//            return binarySearch(nums, target, 0, nums.length-1);
//        }
//
//        if (nums[pivot] == target) {
//            return true;
//        }
//
//        if (target >= nums[0]) {
//            return binarySearch(nums, target, 0, pivot - 1);
//        }
//
//        return binarySearch(nums, target, pivot + 1, nums.length-1);
//    }

    public static boolean binarySearch(int[] arr, int target, int start, int end) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < arr[mid]) {
                end = mid - 1;
            }
            else if (target > arr[mid]) {
                start = mid + 1;
            }
            else if (target == arr[mid]){
                return true;
            }
        }
        return false;
    }

    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && arr[mid] > arr[mid+1]) {
                return mid;
            }

            if (mid > start && arr[mid] < arr[mid-1]) {
                return mid-1;
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
            else if(arr[start] < arr[mid] || (arr[start] == arr[mid] && arr[mid] > arr[end])) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public static boolean search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == target) {
                return true;
            }

            if (nums[mid] == nums[start]) {
                start++; //"duplicate", jump
            }

            // we are on the 'bigger' increasing side, like [5,5,7] from [5,5,7,0,1,3,4]
            else if (nums[mid] > nums[start]) {
                // if target is between nums[start] and nums[mid], it makes sense to set the end = mid-1
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                }
                // if target is NOT between nums[start] and nums[mid] then target is on the 'right' side of mid ; limit the start = mid + 1
                else {
                    start = mid + 1;
                }
            }

            // case nums[mid] < nums[start] : we are on the 'smaller' increasing side, like [0,1,3,4] from [5,5,7,0,1,3,4]
            else {
                // if target is between nums[mid] and nums[end], it makes sense to set the start = mid+1
                if (target <= nums[end] && target > nums[mid]) {
                    start = mid + 1;
                }
                // if target is NOT between nums[mid] and nums[end] then target is on the 'left' side of mid ; limit the end = mid-1
                else {
                    end = mid - 1;
                }
            }
        }
        return false;
    }
}

public class SpecialArray {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/special-array-with-x-elements-greater-than-or-equal-x/
    // Brute Force
//    public int specialArray(int[] nums) {
//        int a = 0;
//        int len  = nums.length;
//        while (a <= len) {
//            int count = 0;
//            for (int num: nums) {
//                if (num >= a) {
//                    count++;
//                }
//            }
//            if (count == a) {
//                return a;
//            } else {
//                a++;
//            }
//        }
//        return -1;
//    }

    // Binary Search
    public int specialArray(int[] nums) {
        int start = 0;
        int end = nums.length;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int curr = count(nums,mid);

            if (curr == mid) {
                return mid;
            } else if (curr > mid) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    public int count(int[] arr, int t) {
        int c = 0;
        for (int num: arr) {
            if (num >= t) {
                c++;
            }
        }
        return c;
    }
}

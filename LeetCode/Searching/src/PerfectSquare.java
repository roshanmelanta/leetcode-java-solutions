public class PerfectSquare {
    public static void main(String[] args) {
        int num = 5;
        System.out.println(isPerfectSquare(num));
    }

    // https://leetcode.com/problems/valid-perfect-square/
    public static boolean isPerfectSquare(int num) {
//        long start = 1;
//        long end = num;
//
//        while (start <= end) {
//            long mid = start + (end - start) / 2;
//            long midSquare = mid * mid;
//
//            if (midSquare == num) {
//                return true;
//            }
//            if (midSquare > num) {
//                end = mid - 1;
//            }
//            else {
//                start = mid + 1;
//            }
//        }
//        return false;

        // without using long
        int left = 1, right = num;
        while (left <= right) {
            int mid = left + (right - left) / 2; // to avoid overflow incase (left+right)>2147483647
            int res = num / mid, remain = num % mid;
            if (res == mid) {
                return true; // check if mid * mid == num
            }
            if (res > mid) { // mid is small -> go right to increase mid
                left = mid + 1;
            } else {
                right = mid - 1; // mid is large -> to left to decrease mid
            }
        }
        return false;
    }
}

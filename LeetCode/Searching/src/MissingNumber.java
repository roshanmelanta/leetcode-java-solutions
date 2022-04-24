public class MissingNumber {
    public static void main(String[] args) {
        int[] arr = {2,3,4,7,11};
        int k = 5;
        System.out.println(findKthPositive(arr, k));
    }
    // https://leetcode.com/problems/kth-missing-positive-number/
    public static int findKthPositive(int[] arr, int k) {
        // Brute Force 1
//        if (arr[0] > k) {
//            return k;
//        }
//
//        int num = k;
//        for (int a: arr) {
//            if (a <= num) {
//                num++;
//            }
//            else {
//                break;
//            }
//        }
//        return num;

        // Brute Force 2
//        if (arr[0] > k) {
//            return k;
//        }
//
//        int i = 0, idx = 0;
//        while (i < arr.length && arr[idx] - (idx + 1) < k) {
//            idx = i + 1;
//            i++;
//        }
//        return k + idx;

        // Binary Search
        if (arr[0] > k) {
            return k;
        }

        int start = 0;
        int end = arr.length - 1;
        int closestMid = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int missingNumbers = arr[mid] - (mid + 1);

            if (missingNumbers < k) {
                closestMid = mid + 1;
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return k + closestMid;
    }
}

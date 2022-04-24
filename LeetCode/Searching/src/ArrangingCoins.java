public class ArrangingCoins {
    public static void main(String[] args) {
        int n = 5;
        System.out.println(arrangeCoins(n));
    }
    // https://leetcode.com/problems/arranging-coins/
    public static int arrangeCoins(int n) {
        // Brute Force
//        int noOfStairs = 1;
//        while (n >= noOfStairs) {
//            n = n - noOfStairs;
//            noOfStairs++;
//        }
//        return noOfStairs-1;

        // Binary Search
        long start = 0;
        long end = n;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = (mid * (mid+1)) / 2;

            if (sum == n ) {
                return (int)mid;
            }

            if (sum > n) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return (int)end;

    }
}

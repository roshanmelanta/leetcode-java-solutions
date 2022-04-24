public class MaxValueBoundedArray {
    // https://leetcode.com/problems/maximum-value-at-a-given-index-in-a-bounded-array/
    public int maxValue(int n, int index, int maxSum) {
        long right = n-index-1; // number of elements to right of mid
        long left = index; // number of elements to left of mid

        long start = 1;
        long end = maxSum;

        long res = 0;

        while (start <= end) {
            long mid = start + (end - start) / 2;
            long sum = mid;
            long leftSum = 0;
            long rightSum = 0;
            long m = mid - 1; // for calculating right sum

            if (right <= m) {
                // Sum of right elements - (Sum of m - right elements)
                rightSum = (m * (m + 1) / 2) - ((m - right) * (m - right + 1) / 2);
            } else {
                // Sum of right elements + (right - m elements)
                rightSum = m * (m + 1) / 2 + (1 * (right - m));
            }

            if (left <= m) {
                // Sum of left elements - (Sum of m - left elements)
                leftSum = (m * (m + 1) / 2) - ((m - left) * (m - left + 1) / 2);
            } else  {
                // Sum of left elements + (left - m elements)
                leftSum = m * (m + 1) / 2 + (1 * (left - m));
            }

            sum += leftSum + rightSum; // Calculate total sum

            if (sum <= maxSum) {
                res = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int)res;
    }
}

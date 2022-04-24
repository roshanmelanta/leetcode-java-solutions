public class SplitArray {
    public static void main(String[] args) {

    }

    // https://leetcode.com/problems/split-array-largest-sum/
    public int splitArray(int[] nums, int m) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end of the loop this will contain the max item of the array
            end += nums[i]; // in the end of the loop this will contain the sum of elements of the array
        }

        // binary search
        while (start < end) {
            // try for the middle as potential answer
            int mid = start + (end - start) / 2;

            // calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for(int num: nums) {
                if (sum + num > mid) {
                    // you cannot add this in this subarray, make new one
                    // say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces <= m) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return end; // here start == end
    }
}

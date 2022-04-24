public class DuplicateNumber {
    // https://leetcode.com/problems/find-the-duplicate-number/
    public int findDuplicate(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        int duplicate = -1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int count = 0;

            for (int i : nums) {
                if (i <= mid) {
                    count++;
                }
            }

            if (count > mid) {
                duplicate = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return duplicate;
    }
}

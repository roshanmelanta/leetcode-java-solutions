public class SortParity2 {
    public int[] sortArrayByParityII(int[] nums) {
        // Brute Force
//        int i = 0; // even pointer
//        int j = 1; // odd pointer
//        int[] res = new int[nums.length];
//        for (int n : nums) {
//            if (n % 2 == 0) { // if even add to this index
//                res[i] = n;
//                i += 2;
//            }
//            else {
//                res[j] = n; // if odd add to this index
//                j += 2;
//            }
//        }
//        return res;

        // Two Pointer
        int i = 0; // even pointer
        int j = 1; // odd pointer
        int n = nums.length;

        while (i < n && j < n) {
            while (i < n && nums[i] % 2 == 0) {
                i += 2; // as long as it is even keep skipping
            }

            while (j < n && nums[j] % 2 == 1) {
                j += 2; // as long as it is odd keep skipping
            }

            // when both have inverse of numbers swap of them
            if (i < n && j < n) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
        return nums;
    }
}

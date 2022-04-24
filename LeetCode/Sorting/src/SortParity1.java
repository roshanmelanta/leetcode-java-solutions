import java.util.Arrays;

public class SortParity1 {
    public int[] sortArrayByParity(int[] nums) {
        // Two-Pass
//         Arrays.sort(nums);
//         int a = 0;
//         int[] result = new int[nums.length];
//
//         // Add all the even elements
//         for (int n : nums) {
//             if (n % 2 == 0) {
//                 result[a++] = n;
//             }
//         }
//
//        // Add all the odd elements
//         for (int n : nums) {
//             if (n % 2 != 0) {
//                 result[a++] = n;
//             }
//         }
//         return result;

        // In-Place
        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            // Swap even number with odd (even --> left side && odd --> right side)
            if (nums[i] % 2 > nums[j] % 2) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }

            if (nums[i] % 2 == 0) i++; // skip if left is already even
            if (nums[j] % 2 == 1) j--; // skip if right is already odd
        }
        return nums;
    }
}

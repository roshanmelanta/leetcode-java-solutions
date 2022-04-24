import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {3,2,3};
        System.out.println(majorityElement(arr));
    }

    // https://leetcode.com/problems/majority-element/
    public static int majorityElement(int[] nums) {
         // Using HashMap
//         int res = 0;
//         Map<Integer, Integer> counts = new HashMap<>();
//         for (int num : nums) {
//             if (!counts.containsKey(num)) {
//                 counts.put(num, 1);
//             }
//             else {
//                 counts.put(num, counts.get(num) + 1);
//             }
//
//             if (counts.get(num) > nums.length / 2) {
//                 res = num;
//                 break;
//             }
//         }
//         return res;

        // Boyer-Moore Voting Algorithm
         int count = 0;
         int result = 0;
         for (int i = 0; i < nums.length; i++) {
             if (count == 0) {
                 result = nums[i];
             }
             count += (nums[i] == result) ? 1 : -1;
         }
         return result;
    }
}

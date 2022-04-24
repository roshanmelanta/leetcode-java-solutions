public class ThirdMaximumNumber {
    // https://leetcode.com/problems/third-maximum-number/
    public int thirdMax(int[] nums) {
        Integer max = null;
        Integer second_max = null;
        Integer third_max = null;

        for (Integer num : nums) {
            // To skip duplicate values
            if (num.equals(max) || num.equals(second_max) || num.equals(third_max)) {
                continue;
            }
            // If new number is max then earlier max is pushed down to second_max and second_max to third_max
            if (max == null || num > max) {
                third_max = second_max;
                second_max = max;
                max = num;
            }
            else if (second_max == null || num > second_max) {
                third_max = second_max;
                second_max = num;
            }
            else if (third_max == null || num > third_max) {
                third_max = num;
            }
        }

        // to check if third max exists or not
        if (third_max == null) {
            return max;
        }

        return third_max;
    }
}

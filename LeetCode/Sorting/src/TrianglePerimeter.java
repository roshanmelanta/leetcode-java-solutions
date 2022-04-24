import java.util.Arrays;

public class TrianglePerimeter {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        // Perimeter of triangle = A + B > C
        // start from third last digit if size greater than 3
        for (int i = nums.length - 3; i >= 0; i--) {
            if (nums[i] + nums[i + 1] > nums[i + 2]) {
                return nums[i] + nums[i + 1] + nums[i + 2];
            }
        }
        return 0;
    }
}

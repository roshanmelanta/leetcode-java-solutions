import java.util.Arrays;

public class MostFrequentElement {
    public static void main(String[] args) {
        int[] nums = {9940,9995,9944,9937,9941,9952,9907,9952,9987,9964,9940,9914,9941,9933,9912,9934,9980,9907,9980,9944,9910,9997};

        System.out.println(maxFrequency(nums, 7925));
    }

    public static int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int freq = 0;
        int count = k;
        int element = binarySearch(nums, k);

        if (element == 0) {
            return nums.length;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                freq++;
                continue;
            }

            if (count > 0) {
                int num = Math.abs(element - nums[i]);
                if (num + nums[i] == element) {
                    count = k - num;
                    freq++;
                }
            }
        }
        return freq;
    }

    public static int binarySearch(int[] nums, int k) {
        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] == k) {
                return k;
            }

            if (nums[0] > k) {
                return 0;
            }

            if (nums[mid] < k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return nums[end];
    }
}

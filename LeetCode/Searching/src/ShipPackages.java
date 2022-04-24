public class ShipPackages {
    public static void main(String[] args) {
        int[] weights = {3,2,2,4,1,4};
        System.out.println(shipWithinDays(weights, 3));
    }

    // https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
    public static int shipWithinDays(int[] weights, int days) {
        int max = 0; // to find lowest possible weight
        int sum = 0; // to find maximum possible weight
        for (int i : weights) {
            if (i >= max) {
                max = i;
            }
            sum += i;
        }


        int start = max;
        int end = sum;
        int res = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            int count = 1;
            int sumDays = 0;
            // To check each subarray for that weight
            for (int i : weights) {
                if (sumDays + i > mid) {
                    count++;
                    sumDays = i;
                } else {
                    sumDays += i;
                }
            }

            if (count >= days) {
                res = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return res;
    }
}

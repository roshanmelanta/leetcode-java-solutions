import java.util.Arrays;

public class KokoBananas {
    public static void main(String[] args) {
        int[] arr = {3,6,7,11};
        int h = 8;
        System.out.println(minEatingSpeed(arr,h));

        System.out.println(Math.ceil(11/2));
    }

    // https://leetcode.com/problems/koko-eating-bananas/
    public static int minEatingSpeed(int[] piles, int h) {
        Arrays.sort(piles);
        int start = 1;
        int end = piles[piles.length - 1];
        int res = 0;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int hourSpent = 0;

            for (int pile: piles) {
                hourSpent += Math.ceil((double)pile / mid);
            }

            if (hourSpent <= h) {
                res = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }
}

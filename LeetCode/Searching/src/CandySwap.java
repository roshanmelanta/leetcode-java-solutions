import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class CandySwap {
    // https://leetcode.com/problems/fair-candy-swap/submissions/
    // Using HashSet
//    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
//        int sumA = 0;
//        int sumB = 0;
//        for(int num: aliceSizes) {
//            sumA += num;
//        }
//        for(int num: bobSizes) {
//            sumB += num;
//        }
//
//        int diff = (sumB - sumA) / 2;
//
//        Set<Integer> set = new HashSet<>();
//        for(int num: bobSizes) {
//            set.add(num);
//        }
//
//        for (int num: aliceSizes) {
//            if (set.contains(num + diff)) {
//                return new int[]{num, num+diff};
//            }
//        }
//        return null;
//    }

    // Binary Search
    public boolean binarySearch(int target, int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int sumA = 0;
        int sumB = 0;
        for(int num: aliceSizes) {
            sumA += num;
        }
        for(int num: bobSizes) {
            sumB += num;
        }

        int diff = (sumB - sumA) / 2;

        Arrays.sort(bobSizes);
        for (int num: aliceSizes) {
            if (binarySearch(num+diff, bobSizes)) {
                return new int[]{num, num+diff};
            }
        }
        return null;

    }


}

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DoubleExist {
    public static void main(String[] args) {
        int[] arr = {-2,0,10,-19,4,6,-8};
        System.out.println(checkIfExist(arr));
    }

    // https://leetcode.com/problems/check-if-n-and-its-double-exist/
    // Using HashSet
//    public static boolean checkIfExist(int[] arr) {
//        Set<Integer> set = new HashSet<>();
//        for (int a: arr) {
//            if (set.contains(a * 2) || (a%2 == 0 && set.contains(a/2))) {
//                return true;
//            }
//            set.add(a);
//        }
//        return false;
//    }

    public static boolean checkIfExist(int[] arr) {
        Arrays.sort(arr);
        int c = 0;
        for (int a: arr) {
            if (a != 0) {
                if (binarySearch(arr, a*2)) {
                    return true;
                }
            }
            else {
                c++;
            }
        }
        return c > 1;
    }

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}

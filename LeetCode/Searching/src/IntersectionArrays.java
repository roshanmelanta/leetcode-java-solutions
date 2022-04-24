import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class IntersectionArrays {
    public static void main(String[] args) {

    }
    
    // https://leetcode.com/problems/intersection-of-two-arrays/
    // Using Two HashSets
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Set<Integer> set = new HashSet<>();
//        for(int num: nums1) {
//            set.add(num);
//        }
//
//        Set<Integer> intersect = new HashSet<>();
//        for(int num: nums2) {
//            if (set.contains(num)) {
//                intersect.add(num);
//            }
//        }
//
//        int[] result = new int[intersect.size()];
//        int index = 0;
//        for(int num: intersect) {
//            result[index++] = num;
//        }
//        return result;
//    }

    // Binary Search
//    public int[] intersection(int[] nums1, int[] nums2) {
//        Arrays.sort(nums1);
//        Set<Integer> intersect = new HashSet<>();
//
//        for(int num: nums2) {
//            if (find(num, nums1)) {
//                intersect.add(num);
//            }
//        }
//
//        int[] result = new int[intersect.size()];
//        int index = 0;
//        for(Integer num: intersect) {
//            result[index++] = num;
//        }
//        return result;
//    }
//
//    boolean find(int target, int[] arr) {
//        int start = 0;
//        int end = arr.length - 1;
//
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//
//            if (arr[mid] == target) {
//                return true;
//            } else if (arr[mid] > target) {
//                end = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//        return false;
//    }

    // Two Pointer
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0;
        int j = 0;

        Set<Integer> intersect = new HashSet<>();

        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                intersect.add(nums1[i]);
                i++;
                j++;
            }
            else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }

        int[] result = new int[intersect.size()];
        int index = 0;
        for(int num: intersect) {
            result[index++] = num;
        }

        return result;
    }
}

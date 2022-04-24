import java.util.Arrays;

public class AggresiveCows {
    public static void main(String[] args) {
        int[] stalls = {1,2,8,4,9};
        int cows = 3;
        System.out.println(minDistance(stalls, cows));
    }

    // Brute Force
    public static int minDistance(int[] stalls, int cows) {
        Arrays.sort(stalls);
        // [1,2,4,8,9]
        int maxDist = stalls[stalls.length - 1] - stalls[0];
        int result = 0;
        for (int i = 1; i <= maxDist; i++) {
            if (isCompatible(stalls, cows, i)) {
                result = i;
            }
        }
        return result;
    }

    // Binary Search
//    public static int minDistance(int[] stalls, int cows) {
//        Arrays.sort(stalls);
//        int maxDist = stalls[stalls.length - 1] - stalls[0];
//        int low = 1; // minimum distance a cow can be separated
//        int high = maxDist; // maximum distance a cow can be separated
//        int res = 0;
//        while (low <= high) {
//            int mid = low + (high - low) / 2;
//
//            // Function to check if given number of cows can be separated efficiently with this distance
//            if (isCompatible(stalls, cows, mid)) {
//                res = mid;
//                low = mid + 1;
//            }
//            else {
//                high = mid - 1;
//            }
//        }
//        return res;
//    }

    public static boolean isCompatible(int[] arr, int cows, int dist) {
       int position = arr[0]; // Position of first cow
       int count = 1;
       for (int i = 1; i < arr.length; i++) {
           if (arr[i] - position >= dist) {
               position = arr[i]; // Position of 2nd, 3rd, 4th ,....N cow
               count++;
           }
           if (count == cows) {
               return true;
           }
       }
       return false;
    }
}

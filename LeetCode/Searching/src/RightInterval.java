import java.util.Arrays;
import java.util.HashMap;

public class RightInterval {
    public static void main(String[] args) {
        int[][] arr = {{3,4},{2,3},{1,2}};
    }

    // https://leetcode.com/problems/find-right-interval/
    public int[] findRightInterval(int[][] intervals) {
        int m = intervals.length;
        int n = intervals[0].length;

        // Create HashMap to store original index of the start points
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] startPoint = new int[m]; // array of start points
        for (int i = 0; i < m; i++) {
            startPoint[i] = intervals[i][0];
            map.put(startPoint[i], i); // //(key=start_point, val=index)
        }

        // sort the start points to run binary search
        Arrays.sort(startPoint);
        int[] result = new int[m];

        for (int i = 0; i < m; i++) {
            int start = 0;
            int end = m - 1;
            boolean found = false; // to check if minimum element is found or not
            int min = -1; //
            int endPoint = intervals[i][n-1]; // end points of array
            while (start <= end) {            // Binary Search on array of start points
                int mid = start + (end - start) / 2;
                if (startPoint[mid] >= endPoint) {
                    min = startPoint[mid];
                    found = true;
                    end = mid - 1;
                }
                else {
                    start = mid + 1;
                }
            }
            result[i] = found ? map.get(min) : -1;
        }
        return result;
    }
}



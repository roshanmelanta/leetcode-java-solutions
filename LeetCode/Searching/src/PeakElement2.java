public class PeakElement2 {
    // https://leetcode.com/problems/find-a-peak-element-ii/
    public int[] findPeakGrid(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        int start = 0;
        int end = m - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int max_row = 0;

            // start with first row and pick the middle column
            // search for rows with maximum element than this row
            // this basically checks for upper and lower elements are lower than mid
            for (int i = 0; i < n; ++i) {
                if (matrix[max_row][mid] < matrix[i][mid]) {
                    max_row = i;
                }
            }

            // check if elements to the right and left of assumed answer are lower
            // mid == 0 && mid == m - 1 help to check for single elements or just 2 elements in the column
            if ((mid == 0 || (matrix[max_row][mid] > matrix[max_row][mid - 1])) &&
                    (mid == m - 1 || (matrix[max_row][mid] > matrix[max_row][mid + 1]))) {
                return new int[]{max_row, mid};
            }
            // if left element is not lower than decrease end by mid - 1
            else if (mid > 0 && matrix[max_row][mid] < matrix[max_row][mid - 1]) {
                end = mid - 1;
            }
            // if right element is not lower than increase start by mid + 1
            else {
                start = mid + 1;
            }
        }
        return new int[]{-1,-1};
    }
}

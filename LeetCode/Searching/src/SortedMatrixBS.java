import java.util.Arrays;

public class SortedMatrixBS {
    public static void main(String[] args) {
        int[][] arr = {
                {}
        };
        System.out.println(Arrays.toString(search(arr, 1)));
    }

    // for binary search
    // At which row and from cStart to cEnd do you want to search
    static int[] binarySearch(int[][] matrix, int target, int row, int cStart, int cEnd) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;

            if (matrix[row][mid] == target) {
                return new int[]{row,mid};
            }
            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            }
            else {
                cEnd = mid - 1;
            }
        }
        return new int[]{-1,-1};
    }

    static int[] search(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // be cautious, matrix maybe empty

        if (rows == 1) {
            return binarySearch(matrix, target,0, 0,  cols-1);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;
        // run the loop till 2 rows are remaining
        while (rStart < (rEnd - 1)) { // while this is true it will have more than two rows
            int mid = rStart + (rEnd - rStart) / 2;

            if (target == matrix[mid][cMid]) {
                return new int[]{mid,cMid};
            }
            if (target > matrix[mid][cMid]) {
                rStart = mid;
            }
            else {
                rEnd = mid;
            }
        }

        // After above loop has run, we have 2 rows
        // Check whether the target is in the column of two rows
        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart,cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1,cMid};
        }

        // search in first half
        if (target <= matrix[rStart][cMid - 1]) {
            return binarySearch(matrix, target, rStart, 0, cMid-1);
        }
        // search in second half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols-1]) {
            return binarySearch(matrix, target, rStart, cMid+1, cols-1);
        }
        // search in third half
        if (target <= matrix[rStart + 1][cMid - 1]) {
            return binarySearch(matrix, target, rStart+1, 0, cMid-1);
        }
        // search in fourth half
        //if (target >= matrix[rStart + 1][cMid + 1]) {
        else {
            return binarySearch(matrix, target, rStart+1, cMid+1, cols-1);
        }
    }
}

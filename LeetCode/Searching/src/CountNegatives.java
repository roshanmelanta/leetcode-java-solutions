public class CountNegatives {
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
        System.out.println(countNegatives(grid));
    }

    // https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
//    public static int countNegatives(int[][] grid) {
//       // Brute Force O(M+N)
//        int m = grid.length;
//        int n = grid[0].length;
//        int count = 0;
//        int row = 0, col = n - 1;
//
//        while (row < m && col >= 0) {
//            if (grid[row][col] < 0) {
//                count += m - row;
//                col -= 1;
//            }
//            else {
//                row += 1;
//            }
//        }
//        return count;
//    }

    public static int countNegatives(int[][] grid) {
        int count = 0;
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            count += negativeEachRow(grid[i]);
        }
        return count;
    }

    public static int negativeEachRow(int[] arr) {
        int count = 0;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (arr[mid] < 0) {
                count += (end - mid) + 1;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return count;
    }
}

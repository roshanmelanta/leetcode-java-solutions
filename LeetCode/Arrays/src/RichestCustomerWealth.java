import java.util.Scanner;

public class RichestCustomerWealth {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter number of rows: ");
        int row = input.nextInt();

        System.out.print("Enter number of columns: ");
        int col = input.nextInt();

        int[][] arr = new int[row][col];

        for (int i = 0; i < row; i++) {
            System.out.println("Enter elements in row " + (i+1) + ": ");
            for (int j = 0; j < col; j++) {
                arr[i][j] = input.nextInt();
            }
        }
        System.out.println("Max wealth: " + maximumWealth(arr));
    }

    public static int maximumWealth(int[][] nums) {
        int max = 0, sum;
        int len  = nums.length;

        for (int i = 0; i < len; i++) {
            sum = 0;
            for (int j = 0; j < nums[i].length; j++) {
                sum = sum + nums[i][j];
            }

            if(max < sum) {
                max = sum;
            }
        }
        return max;
    }
}

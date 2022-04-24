import java.util.Arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int[] arr= {3,0,1};
        System.out.println(missingNumber(arr));
    }


    // https://leetcode.com/problems/missing-number/submissions/
    public static int missingNumber(int[] arr) {
        int i = 0;
        int n = arr.length;
        while ( i < n) {
            int correctIndex = arr[i];
            if (arr[i] < n && arr[i] != arr[correctIndex]) {
                swap(arr, i, correctIndex);
            }
            else {
                i++;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (int j = 0; j < n; j++) {
            if (arr[j] != j) {
                return j;
            }
        }
        return n;
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }
}

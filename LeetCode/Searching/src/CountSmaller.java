import java.util.ArrayList;
import java.util.List;

public class CountSmaller {
    public static void main(String[] args) {
        int[] arr = {5,2,6,1};
        List<Integer> n = countSmaller(arr);
        for (int num: n) {
            System.out.print(num + " ");
        }
    }

    public static List<Integer> countSmaller(int[] nums) {
        int pointer = 0;
        List<Integer> result = new ArrayList<>();
        while (pointer < nums.length) {
            int count = 0;
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] < nums[pointer]) {
                    count++;
                }
            }
            result.add(count);
            pointer++;
        }
        return result;
    }
}

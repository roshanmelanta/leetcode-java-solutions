import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    // https://leetcode.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            // check if number already exists in HashSet
            if (set.contains(nums[i])) {
                return true; // if it does it's a duplicate
            }
            else {
                set.add(nums[i]); // if it does not exist add it to set
            }
        }
        return false;
    }
}

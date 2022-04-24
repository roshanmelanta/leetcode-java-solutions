// (744. Find Smallest Letter Greater Than Target)[https://leetcode.com/problems/find-smallest-letter-greater-than-target/]

public class SmallestNumber {
    public static void main(String[] args) {
        char[] arr = {'c','f','j'};
        char target = 'a';
        System.out.println(nextGreatestLetter(arr, target));
    }

    static char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        // find the middle element
        // int mid = (start + end) / 2; // might be possible that (start + end) exceeds the range of int in java
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if (target < letters[mid]) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        // For letters wrap around
        return letters[start % letters.length];
    }
}

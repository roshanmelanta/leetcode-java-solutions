public class MergeSortedArrays {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // last index of nums1
        int lastIndex = m + n - 1;

        // merge in reverse order by comparing
        while (m > 0 && n > 0) {
            if (nums1[m - 1] < nums2[n - 1]) {
                nums1[lastIndex] = nums2[n - 1];
                n--;
            }
            else { // nums1[m - 1] >= nums2[n - 1]
                nums1[lastIndex] = nums1[m - 1];
                m--;
            }
            lastIndex--;
        }

        // fill nums1 with leftover nums2 elements
        while (n > 0) {
            nums1[lastIndex] = nums2[n - 1];
            lastIndex--;
            n--;
        }
    }
}

public class BookAllocation {
    public static void main(String[] args) {
        int[] pages = {12, 34, 67, 90};
        int m = 2;
        System.out.println(findPages(pages, m));
    }

    // https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1/#
    public static int findPages(int[] pages, int m) {
        int minPages = Integer.MIN_VALUE;
        int maxPages = 0;
        for (int i = 0; i < pages.length; i++) {
            if (pages[i] >= minPages) {
                minPages = pages[i];
            }
            maxPages += pages[i];
        }

        int start = minPages;
        int end = maxPages;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int sum = 0;
            int students = 1;
            for(int num: pages) {
                if (sum + num > mid) {
                    sum = num;
                    students++;
                } else {
                    sum += num;
                }
            }

            if (students <= m) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return end;
    }
}

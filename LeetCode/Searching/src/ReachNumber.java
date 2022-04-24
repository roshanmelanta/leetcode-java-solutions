public class ReachNumber {
    // https://leetcode.com/problems/reach-a-number/
//    public int reachNumber(int target) {
//        target = Math.abs(target);
//        int step = 0, sum = 0;
//        while (sum < target) {
//            step++;
//            sum += step;
//        }
//
//        while ((sum - target) % 2 != 0) {
//            step++;
//            sum += step;
//        }
//        return step;
//    }

    // Binary Search
    public int reachNumber(int target) {
        target = Math.abs(target);
        int step = findStep(target); // Find number of steps with summation greater than or equal to target
        int sum = (int)findSum((long)step); // find sum of steps by formula
        while ((sum - target) % 2 != 0) {
            step++;
            sum += step;
        }
        return step;
    }

    // To find how many steps does it take by checking sum of mid and applying condition if that sum < target or not
    public int findStep(int target) {
        long start = 1l, end = target; // Ignore 0 as target will not be equal to 0
        while (start < end) {
            long mid = start + (end - start) / 2;
            long sum = findSum(mid);

            if (sum < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        // In the end only that number will be remaining whose sum is next greater element after target
        return (int)start; // or end
    }

    // Function to find sum of number
    public long findSum(long n) {
        return (n*(n+1)) / 2;
    }
}

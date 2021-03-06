/**
 * Solution: use binary search to find mid and redefine low and high.
 * Time Complexity: O(logn)
 * Space Complexity: O(1)
 */
public class Sqrt {
    public int mySqrt(int x) {
        if (x <= 0) return 0;
        int low = 1;
        int high = x;
        while (low <= high) {
            long mid = low + (high - low) / 2;
            if (mid * mid == x) {
                return (int) mid;
            } else if (mid * mid < x) {
                low = (int) mid + 1;
            } else {
                high = (int) mid - 1;
            }
        }
        if (high * high < x) {
            return (int) high;
        }
        return (int) low;
    }
}

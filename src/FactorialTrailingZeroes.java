/**
 * Solution: 10 is the product of 2 and 5. In n!, we need to know how many 2 and 5,
 *      and the number of zeros is the minimum of the number of 2 and the number of 5.
 *      Since multiple of 2 is more than multiple of 5, the number of zeros is dominant
 *      by the number of 5.
 * Time Complexity: O(log5(n))
 * Space Complexity: O(n) ? O(log5(n))
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }
}

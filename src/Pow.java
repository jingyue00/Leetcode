/**
 * Solution: each time let n / 2, and let cur *= cur,
 *      consider both odd and even number of n, they have different situations.
 * Time Complexity: O(logn)
 * Space Complexity: O(logn)
 */
public class Pow {
    public double pow(double x, int n) {
        if (n > 0) {
            return myPow(x, n);
        } else {
            return 1.0 / myPow(x, n);
        }
    }

    public double myPow(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double y = myPow(x, n / 2);
        if (n % 2 == 0) {
            return y * y;
        } else {
            return y * y * x;
        }
    }

    /**
     * Solution: first get abs of n - absN, if absN > 0 and absN is even, x *= x, absN /= 2;
     *      if absN is odd, don't forget res *= x
     *      Important, if n < 0, 1.0 / res;
     * Time Complexity: O(logn)
     * Space Complexity: O(1)
     */
    public static double myPow1(double x, int n) {
        if (n == 0) return 1;
        double res = 1;
        // int : -6.. ~ +6..  -2^32 ~ 2 ^32-1 Integer.MIN_VALUE
        long abs = Math.abs((long)n);
        while (abs > 0) {
            if (abs % 2 != 0) {
                res *= x;
            }
            x *= x;
            abs /= 2;
        }
        if (n < 0) {
            return 1.0 / res;
        }
        return res;
    }

}

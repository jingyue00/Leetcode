/**
 * Solution: Since each time we can either climb 1 or 2 steps.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ClimbingStairs {

    public int climbStairs(int n) {
        if (n <= 1) return 1;
        int one = 1, two = 1, res = 0;
        for (int i = 2; i <= n; i++) {
            res = one + two;
            two = one;
            one = res;
        }
        return res;
    }

    public int climbStairs2(int n) {
        if (n <= 2) {
            return n;
        } else {
            return climbStairs(n - 1) + climbStairs(n - 2);
        }
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(3));
        System.out.println(cs.climbStairs2(4));
    }
}

/**
 * Solution: the way to solve position number, negative number and number ends with 0 are the same
 *      Use the while loop, res equals res * 10 and add reminder of x, then x / 10 to check next digit
 *      Important: don't forget to compare with the limit, Integer.Max_VALUE and Integer.MIN_VALUE
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ReverseInteger {
    public int reverse(int x) {
        long res = 0;
        while (x != 0) {
            res = res * 10 + x % 10;
            x /= 10;
            if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {
                return 0;
            }
        }
        return (int)res;
    }

    public static void main(String[] args) {
        ReverseInteger ri = new ReverseInteger();
        System.out.println(ri.reverse(-123));
        System.out.println(ri.reverse(120));
    }
}

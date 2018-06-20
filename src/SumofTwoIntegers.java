/**
 * Solution: If we cannot use + and * to add two number, we need to use bit operation.
 *      there are two input int a and int b. First we need to find carry of each bit use &.
 *      Then use ^ to get the value without carry and move carry << 1 to add and find
 *      next round carry until one of input equals 0;
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class SumofTwoIntegers {
    public int getSum(int a, int b) {
        if (a == 0) {
            return b;
        } else if (b == 0) {
            return a;
        }
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }

    public static void main(String[] args) {
        SumofTwoIntegers sti = new SumofTwoIntegers();
        System.out.println(sti.getSum(1,2));
        System.out.println(sti.getSum(999, 111));
    }
}

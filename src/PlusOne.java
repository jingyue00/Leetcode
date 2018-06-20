/**
 * Solution: loop from the last digit of digits, if the digit is smaller than 9, we can add 1
 *      and directly stop. Else let the digit become 0 and continue to check next digit.
 *      If we cannot stop before finish the loop, we need to build a new array and set first
 *      digit to 1.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PlusOne {
    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    public static void main(String[] args) {
        PlusOne po = new PlusOne();
        System.out.println(po.plusOne(new int[]{1,2,3}));
    }
}

/**
 * Solution: First check the sign of integer at str.charAt(0), then loop the string
 *      if not equal to digit, return res * sign, else, res * 10 + (str.charAt(start) - '0')
 *      Important: Since res may larger then range of Integer, set res as long.
 *      check res > Integer.MAX_VALUE during the loop, and don't forget to transfer from
 *      type long to int using (int) to return the value.
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class StringtoInteger {
    public int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }
        int firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            start ++;
        } else if (firstChar == '-') {
            sign = -1;
            start ++;
        }
        while (start < str.length()) {
            if (!Character.isDigit(str.charAt(start))) {
                return (int) res * sign;
            }
            res = res * 10 + (str.charAt(start) - '0');
            if (sign == 1 && res > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            if (sign == -1 && res > Integer.MAX_VALUE) return Integer.MIN_VALUE;
            start ++;
        }
        return (int) res * sign;
    }
}

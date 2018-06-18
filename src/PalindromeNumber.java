/**
 * Requirement: find palindrome of a integer, ex 121
 * Solution: if integer x smaller then 0, or x != 0 and x is multiples of 10 return false
 *      Each time we use while loop and reminder to get the last digit of integer x
 *      if the value if larger then 0, we need to 10 times the exist value and add new digit to reversed integer
 *      Then divide the integer x by 10 to continue check the loop.
 *      Finally compare the origin integer and reversed integer
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0 || x % 10 == 0 && x != 0) {
            return false;
        }
        int origin = x;
        int res = 0;
        while (x > 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }
        return origin == res;
    }

    public static void main(String[] args) {
        PalindromeNumber pn = new PalindromeNumber();
        System.out.println(pn.isPalindrome(121));
        System.out.println(pn.isPalindrome(-121));
    }
}

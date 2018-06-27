/**
 * Solution: go through the palindrome. Each position, have left and right pointers to check the same character
 *      Important: Need to check both odd and even number length of string.
 * Time Complexity: O(n ^ 2)
 * Space Complexity: O(1)
 */
public class LongestPalindrome {

    String res = "";

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            checkPalindrome(s, i, i);
            checkPalindrome(s, i, i + 1);
        }
        return res;
    }

    public void checkPalindrome(String s, int left, int right) {
        while (left >= 0 && right <= s.length() - 1 && s.charAt(left) == s.charAt(right)) {
            left --;
            right ++;
        }
        String cur = s.substring(left + 1, right);
        if (cur.length() > res.length()) {
            res = cur;
        }
    }

    public static void main(String[] args) {
        LongestPalindrome lp = new LongestPalindrome();
        System.out.println(lp.longestPalindrome("babad"));
    }
}

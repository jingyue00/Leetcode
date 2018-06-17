import java.util.Arrays;

/**
 * Requirement: Find the largest prefix of list of String.
 * Solution: let init value of res equals strs[0]. Use while loop to compare res with the following
 *      strings in strs[] one by one. Then Use while loop to match res with strings. if it could be match,
 *      keep the value; else, get rid of last character of res and match them again.
 *      Important: to match the value, we can use indexOf(), if it could not be match, the value is not
 *      equal to 1. to cut the string, we can use substring() to keep the string from 0 to length - 1.
 * Time Complexity: O(n * m)  // Time complexity of indexOf() is O(m*n), Arrays.sort() is O(nlogn)
 * Space Complexity: O(1)
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        String res = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(res) != 0) {
                res = res.substring(0, res.length() - 1);
            }
        }
        return res;
        /*
        Method 2:
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[0].charAt(i) == strs[j].charAt(i)) {
                    if (j == strs.length - 1) {
                        sb.append(strs[0].charAt(i));
                    }
                } else {
                    break;
                }
            }
        }
        return sb.toString();*/
    }

    public static void main(String[] args) {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        System.out.println(lcp.longestCommonPrefix(new String[]{"edwardshi", "edward", "edwar", "edwardshidd"}));
    }
}

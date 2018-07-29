/**
 * 186. Reverse Words in a String II
 *
 * Given an input string, reverse the string word by word.
 * A word is defined as a sequence of non-space characters.
 *
 * The input string does not contain leading or trailing spaces
 * and the words are always separated by a single space.
 *
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 *
 * Could you do it in-place without allocating extra space?
 *
 * Solution: first reverse whole string, then reverse each word
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseWordsinaStringII {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        int start = 0;
        for (int i = 0; i < str.length; i++) {
            if (i == 0 || (str[i] != ' ' && str[i -1] == ' ')) {
                start = i;
            }
            if (i == str.length - 1 || (str[i] != ' ' && str[i + 1] == ' ')) {
                reverse(str, start, i);
            }

        }
    }

    public void reverse(char[] str, int left, int right) {
        while (left < right) {
            char tmp = str[left];
            str[left++] = str[right];
            str[right--] = tmp;
        }
    }
}

/**
 * 151. Reverse Words in a String
 *
 * Given an input string, reverse the string word by word.
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Solution: Step 1: reverse the whole String, Step 2: reverse each words
 *      Important: Don't forget to trim the String
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class ReverseWordsinaString {
    public String reverseWords(String s) {
        if (s == null || s.length() < 1) {
            return s;
        }
        char[] array = s.trim().toCharArray();
        int i = 0, j = array.length - 1;
        reverse(array, i, j);
        int k = 0;
        for (int n = 0; n < array.length; n++) {
            if (array[n] != ' ' && (n == 0 || array[n - 1] == ' ')) {
                k = n;
            }
            if (array[n] != ' ' && (n == array.length - 1 || array[n + 1] == ' ')) {
                reverse(array, k, n);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int m = 0; m < array.length; m++) {
            if (m == array.length - 1) {
                if (m != ' ') {
                    sb.append(array[m]);
                }
            } else if (array[m] != ' ' && array[m + 1] == ' ') {
                sb.append(array[m]).append(' ');
            } else if (array[m] != ' ') {
                sb.append(array[m]);
            }
        }
        return sb.toString();
    }

    public void reverse(char[] array, int i, int j) {
        while (i < j) {
            char tmp = array[i];
            array[i++] = array[j];
            array[j--] = tmp;
        }
    }

    public static void main(String[] args) {
        ReverseWordsinaString ri = new ReverseWordsinaString();
        System.out.println(ri.reverseWords("   a    b "));
    }
}

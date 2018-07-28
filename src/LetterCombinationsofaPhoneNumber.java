import java.util.LinkedList;
import java.util.List;

/**
 * 17. Letter Combinations of a Phone Number
 *
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 *
 * Solution: Use queue to save each character, for the new digit, poll element from from left
 *      add new character to String and then save to queue from right side
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class LetterCombinationsofaPhoneNumber {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> res = new LinkedList<>();
        if (digits == null || digits.length() == 0) {
            return res;
        }
        String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");
        for (int i = 0; i < digits.length(); i++) {
            int num = digits.charAt(i) - '0';
            while (res.peek().length() == i) {
                String t = res.remove();
                for (char s : mapping[num].toCharArray()) {
                    res.add(t + s);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        LetterCombinationsofaPhoneNumber lcp = new LetterCombinationsofaPhoneNumber();
        System.out.println(lcp.letterCombinations("23"));
        //System.out.println(lcp.letterCombinations(new int[]{1,2}, new int[]{3,4}));
    }
}

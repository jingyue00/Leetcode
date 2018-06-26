import java.util.LinkedList;
import java.util.List;

/**
 * Solution: use backtracking (recursion). Stop the recursion when left > right or left == 0 and right == 0
 *      Important: each recursion need to check left > 0 or right > 0
 * Time Complexity: O(2^n) ? O(2^n)(n!)
 * Space Complexity: O(n)
 */
public class GenerateParentheses {
    public static List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        if (n == 0) return res;
        String s = "";
        getParenthesis(res, s, n, n);
        return res;
    }

    public static void getParenthesis(List<String> res, String s, int left, int right) {
        if (left > right) {
            return;
        }
        if (right == 0 && left == 0) {
            res.add(s);
            return;
        }
        if (left > 0) {
            getParenthesis(res, s + '(', left - 1, right);
        }
        if (right > 0) {
            getParenthesis(res, s + ')', left, right - 1);
        }
    }

    public static void main(String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}

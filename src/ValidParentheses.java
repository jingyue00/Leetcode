import java.util.Deque;
import java.util.LinkedList;

/**
 * Solution: Use stack to check parentheses, go through each character in s using for loop,
 *      if character equals '(', put ')' in stack; '[' put ']', '{' put '}';
 *      else if stack is empty or value poll from stack not equals to current character return false
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Deque<Character> stack = new LinkedList<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.offerFirst(')');
            } else if (ch == '[') {
                stack.offerFirst(']');
            } else if (ch == '{') {
                stack.offerFirst('}');
            } else {
                if (stack.isEmpty() || stack.pollFirst() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()[]{}"));
        System.out.println(vp.isValid("([)]"));
        System.out.println(vp.isValid("}"));
    }
}

import java.util.Deque;
import java.util.LinkedList;

/**
 * 682. Baseball Game
 *
 * You're now a baseball game point recorder.
 *
 * Given a list of strings, each string can be one of the 4 following types:
 *
 * Integer (one round's score): Directly represents the number of points you get in this round.
 *
 * "+" (one round's score): Represents that the points you get in this round
 * are the sum of the last two valid round's points.
 *
 * "D" (one round's score): Represents that the points you get in this round
 * are the doubled data of the last valid round's points.
 *
 * "C" (an operation, which isn't a round's score): Represents the last valid round's points
 * you get were invalid and should be removed.
 *
 * Each round's operation is permanent and could have an impact on the round before and the round after.
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Solution: use stack and switch case to get all number, and add them to sum
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        Deque<Integer> stack = new LinkedList<>();
        int sum = 0;
        for (String op : ops) {
            switch (op) {
                case "+":
                    int second = stack.pollFirst();
                    int first = stack.peekFirst();
                    stack.offerFirst(second);
                    stack.offerFirst(second + first);
                    break;
                case "C":
                    stack.pollFirst();
                    break;
                case "D":
                    stack.offerFirst(stack.peekFirst() * 2);
                    break;
                default:
                    stack.offerFirst(Integer.parseInt(op));
            }
        }
        while (!stack.isEmpty()) {
            sum += stack.pollFirst();
        }
        return sum;
    }
}

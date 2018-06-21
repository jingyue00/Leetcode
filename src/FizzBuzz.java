import java.util.LinkedList;
import java.util.List;

/**
 * Solution: go through 1 to n, if n % 3 and 5, add "FizzBuzz", else if n % 3, add "Fizz", else if
 *      n % 5, add "Buzz", else add itself (transfer from int to String using String.valueOf() or
 *      Integer.toString()).
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class FizzBuzz {
    public List<String> fizzBuzz(int n) {
        List<String> myList = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                myList.add("FizzBuzz");
            } else if (i % 3 == 0) {
                myList.add("Fizz");
            } else if (i % 5 == 0) {
                myList.add("Buzz");
            } else {
                myList.add(String.valueOf(i));
            }
        }
        return myList;
    }
}

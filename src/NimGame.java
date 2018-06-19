/**
 * Requirement: each time remove 1 to 3 stones, people who remove the last stone is the winner
 * Solution: To analyst the result, we can find if we take first turn, we will lose when n % 4 == 0
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class NimGame {
    public boolean canWinNim(int n) {
        return n % 4 != 0;
    }

    public static void main(String[] args) {
        NimGame ng = new NimGame();
        System.out.println(ng.canWinNim(7));
    }
}

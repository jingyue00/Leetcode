/**
 * Solution: Go through each position in board, if it match the letter, check left, right,
 *      up, down, letter for the next step.
 *      Important: in order not to repeat previous matching letter, first let board[i][j] = '#'
 *      then change it back after recursion.
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        boolean result = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j ++) {
                if (existWord(board, i, j, word, 0)) {
                    result = true;
                }
            }
        }
        return result;
    }

    public boolean existWord(char[][] board, int i, int j, String word, int index) {
        if (index >= word.length()) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return false;
        if (board[i][j] == word.charAt(index++)) {
            char c = board[i][j];
            board[i][j] = '#';
            boolean res = existWord(board, i + 1, j, word, index) ||
                    existWord(board, i - 1, j, word, index) ||
                    existWord(board, i, j + 1, word, index) ||
                    existWord(board, i, j - 1, word, index);
            board[i][j] = c;
            return res;
        }
        return false;
    }
}

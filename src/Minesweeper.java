/**
 * 529. Minesweeper
 *
 * Let's play the minesweeper game (Wikipedia, online game)!
 *
 * You are given a 2D char matrix representing the game board.
 * 'M' represents an unrevealed mine,
 * 'E' represents an unrevealed empty square,
 * 'B' represents a revealed blank square that has no adjacent
 * (above, below, left, right, and all 4 diagonals) mines,
 * digit ('1' to '8') represents how many mines are adjacent to this revealed square,
 * and finally 'X' represents a revealed mine.
 *
 * Now given the next click position (row and column indices)
 * among all the unrevealed squares ('M' or 'E'),
 * return the board after revealing this position according to the following rules:
 *
 * If a mine ('M') is revealed, then the game is over - change it to 'X'.
 * If an empty square ('E') with no adjacent mines is revealed,
 * then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
 *
 * If an empty square ('E') with at least one adjacent mine is revealed,
 * then change it to a digit ('1' to '8') representing the number of adjacent mines.
 * Return the board when no more squares will be revealed.
 *
 * Solution: use dfs check 8 connected adjacent. Only recursion if current square == 'B'
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class Minesweeper {
    public char[][] updateBoard(char[][] board, int[] click) {
        int row = click[0];
        int column = click[1];
        if (board[row][column] == 'M') {
            board[row][column] = 'X';
            return board;
        }
        dfs(board, row, column);
        return board;
    }

    int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    public void dfs(char[][] board, int row, int column) {
        if (row < 0 || column < 0 || row > board.length - 1 || column > board[0].length - 1 || board[row][column] != 'E') {
            return;
        }
        int mines = 0;
        for (int[] dir : dirs) {
            if (isMine(board, row + dir[0], column + dir[1])) {
                mines++;
            }
        }
        if (mines == 0) {
            board[row][column] = 'B';
            for (int[] dir : dirs) {
                dfs(board, row + dir[0], column + dir[1]);
            }
        } else {
            board[row][column] = (char) ('0' + mines);
        }
    }

    public boolean isMine(char[][] board, int row, int column) {
        return row >= 0 && column >=0 && row < board.length && column < board[0].length && board[row][column] == 'M';
    }
}

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * 694. Number of Distinct Islands
 *
 * Given a non-empty 2D array grid of 0's and 1's,
 * an island is a group of 1's (representing land) connected 4-directionally (horizontal or vertical.)
 *
 * You may assume all four edges of the grid are surrounded by water.
 * Count the number of distinct islands.
 *
 * An island is considered to be the same as another if and only if
 * one island can be translated (and not rotated or reflected) to equal the other.
 *
 * Solution:
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class NumberOfDistinctIslands {
    public int numDistinctIslands(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Set<String> set = new HashSet<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    String s = bfs(grid, visited, i, j);
                    set.add(s);
                }
            }
        }
        return set.size();
    }

    int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    public String bfs(int[][] grid, boolean[][] visited, int row, int column) {
        Queue<int[]> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(new int[]{row, column});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 0; i < dirs.length; i++) {
                int[] dir = dirs[i];
                int x = cur[0] + dir[0];
                int y = cur[1] + dir[1];
                if (isValid(grid, x, y) && !visited[x][y] && grid[x][y] == 1) {
                    visited[x][y] = true;
                    queue.offer(new int[]{x, y});
                    sb.append(i);
                }
            }
            sb.append(",");
        }
        return sb.toString();
    }

    public boolean isValid(int[][] grid, int x, int y) {
        return x >= 0 && y >= 0 && x < grid.length && y < grid[0].length;
    }
}

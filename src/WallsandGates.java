/**
 * Solution: if value = 0, use dfs check its left right up down.
 * Time Complexity: O(m * n)
 * Space Complexity: O(m * n)
 */
public class WallsandGates {
    public void wallsAndGates(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[0].length; j++) {
                if (rooms[i][j] == 0) {
                    dfs(rooms, i, j, 0);
                }
            }
        }
    }

    public void dfs(int[][] rooms, int i, int j, int dis) {
        if (i < 0 || j < 0 || i >= rooms.length || j >= rooms[0].length || rooms[i][j] < dis) return;
        rooms[i][j] = dis;
        dfs(rooms, i + 1, j, dis + 1);
        dfs(rooms, i - 1, j, dis + 1);
        dfs(rooms, i, j + 1, dis + 1);
        dfs(rooms, i, j - 1, dis + 1);
    }
}

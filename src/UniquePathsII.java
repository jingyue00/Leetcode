/**
 * Solution: array res at position j in current level = node at j - 1 in current level + node
 *      at j in previous level. If obstacleGrid[i][j] == 1, let res[j] = 0;
 * Time Complexity: O(m * n)
 * Space Complexity: O(n)
 */
public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] res = new int[obstacleGrid[0].length];
        res[0] = 1;
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[0].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    res[j] = 0;
                } else if (j > 0) {
                    res[j] += res[j - 1];
                }
            }
        }
        return res[obstacleGrid[0].length - 1];
    }
}

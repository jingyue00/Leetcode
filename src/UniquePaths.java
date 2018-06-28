/**
 * Solution: node at j in current level = node at j - 1 in current level + node at j in
 *      previous level.
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 */
public class UniquePaths {

    public int uniquePaths(int m, int n) {
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[n - 1];
    }


    public int uniquePaths1(int m, int n) {
        int[][] res = new int[m][n];
        for (int i = 0; i < m; i++) {
            res[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            res[0][j] = 1;
        }
        for (int p = 1; p < m; p++) {
            for (int q = 1; q < n; q++) {
                res[p][q] = res[p - 1][q] + res[p][q - 1];
            }
        }
        return res[m - 1][n - 1];
    }
}

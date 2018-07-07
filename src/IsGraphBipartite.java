import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**                                                  / 3
 * Requirement: e.g. [[1,3], [0,2], [1,3], [0,2]]  0 -- 1
 * Solution: Use stack to save current node and its neighbors,
 *      Use Arrays.fill(color, -1); to fill origin array to -1
 *      use color[nei] = color[node] ^ 1 to decide current node = 0 or 1
 * Time Complexity: O(N + E)
 * Space Complexity: O(N)
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if(color[i] == -1) {
                Deque<Integer> stack = new LinkedList<>();
                stack.offerFirst(i);
                color[i] = 0;
                while (!stack.isEmpty()) {
                    int node = stack.pollFirst();
                    for (int nei : graph[node]) {
                        if (color[nei] == -1) {
                            stack.offerFirst(nei);
                            color[nei] = color[node] ^ 1;
                        } else if (color[nei] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}

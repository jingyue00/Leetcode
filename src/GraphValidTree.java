import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Solution: check whether the graph have loop
 *      Important: need to use visited.size() == n ? true : false check whether there is
 *      unique node
 * Time Complexity: O(edges * nodes)
 * Space Complexity: O(n)
 */
public class GraphValidTree {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
        }
        Set<Integer> visited = new HashSet<>();
        visited.add(0);
        boolean res = helper(graph, visited, 0, -1);
        if (res == false) return false;
        return visited.size() == n ? true : false;
    }

    public boolean helper(List<List<Integer>> graph, Set<Integer> visited, Integer node, Integer parent) {
        List<Integer> cur = graph.get(node);
        for (int i : cur) {
            if (i == parent) continue;
            if (visited.contains(i)) {
                return false;
            }
            visited.add(i);
            boolean res = helper(graph, visited, i, node);
            if (res == false) return false;
        }
        return true;
    }
}

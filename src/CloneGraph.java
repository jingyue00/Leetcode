import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution: Use HashMap contains the duplicate of the node.
 * Time Complexity: O(m + n) m : nodes n : edges
 * Space Complexity: O(m)
 */
public class CloneGraph {
    Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        return helper(node);
    }

    public UndirectedGraphNode helper(UndirectedGraphNode node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);
        UndirectedGraphNode dup = new UndirectedGraphNode(node.label);
        map.put(node, dup);
        for (UndirectedGraphNode nei : node.neighbors) {
            UndirectedGraphNode clone = helper(nei);
            dup.neighbors.add(clone);
        }
        return dup;
    }

    class UndirectedGraphNode {
        int label;
        List<UndirectedGraphNode> neighbors;
        UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
    };
}

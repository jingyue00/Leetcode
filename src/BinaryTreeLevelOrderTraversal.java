import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Solution: Use queue to save the node, use the size of queue in each level to record
 *      the number of node.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        TreeNode cur = root;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> curLevel = new LinkedList<>();
            int curSize = queue.size();
            while (curSize > 0) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null) queue.offer(curNode.left);
                if (curNode.right != null) queue.offer(curNode.right);
                curLevel.add(curNode.val);
                curSize--;
            }
            res.add(curLevel);
        }
        return res;
    }

    public static List<List<Integer>> levelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        helper(res, root, 0);
        return res;
    }

    public static void helper(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            res.add(new ArrayList<>());
        }
        res.get(level).add(root.val);
        helper(res, root.left, level + 1);
        helper(res, root.right, level + 1);
    }
}

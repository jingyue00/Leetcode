import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 199. Binary Tree Right Side View
 * Given a binary tree
 * imagine yourself standing on the right side of it
 * return the values of the nodes you can see ordered from top to bottom.
 *
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 *
 * Solution: use queue get TreeNode from right to left in each level
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTreeRightSideView {
    // BFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (i == 0) {
                    res.add(cur.val);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
            }
        }
        return res;
    }

    //DFS
    public List<Integer> rightSideViewII(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        getRightSideView(res, root, 0);
        return res;
    }

    public void getRightSideView(List<Integer> res, TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (level == res.size()) {
            res.add(root.val);
        }
        getRightSideView(res, root.right, level + 1);
        getRightSideView(res, root.left, level + 1);
    }
}

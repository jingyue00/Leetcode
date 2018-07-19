import java.util.ArrayList;
import java.util.List;

/**
 * * 257. Binary Tree Paths
 * Given a binary tree, return all root-to-leaf paths.
 * For example, given the following binary tree:
 *
 *   1
 *  / \
 * 2   3
 *  \
 *   5
 *
 * All root-to-leaf paths are:
 * ["1->2->5", "1->3"]
 *
 * Solution: Use recursion to check each path, and add string to list at leaf node.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        getPath(root, res, "");
        return res;
    }

    public List<String> getPath(TreeNode root, List<String> res, String path) {
        if (root.left == null && root.right == null) {
            res.add(path + root.val);
        }
        if (root.left != null) getPath(root.left, res, path + root.val + "->");
        if (root.right != null) getPath(root.right, res, path + root.val + "->");
        return res;
    }
}

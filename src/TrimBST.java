/**
 * Solution: check current node continue recursion,
 *      if it equal to null, larger then R or smaller then L
 *      root.left = trimBST root.left, same as root.right, return root after recursion.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class TrimBST {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
}

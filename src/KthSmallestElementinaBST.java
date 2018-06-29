import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Solution: use inorder traverse. if current node != null, add to stack
 *      if current node == null, poll node from stack, add it to res
 *      let current node = polled node and let cur = cur.right
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class KthSmallestElementinaBST {
    public int kthSmallest(TreeNode root, int k) {
        List<TreeNode> preOrder = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            if (cur != null) {
                stack.offerFirst(cur);
                cur = cur.left;
            } else {
                cur = stack.pollFirst();
                preOrder.add(cur);
                cur = cur.right;
            }
        }
        return preOrder.get(k - 1).val;
    }

    /**
     * Use Binary search. Each time count left half, and reset range
     */
    public int kthSmallestI(TreeNode root, int k) {
        int count = countNodes(root.left);
        if (k <= count) {
            return kthSmallest(root.left, k);
        } else if (k > count + 1) {
            return kthSmallest(root.right, k-1-count); // 1 is counted as current node
        }
        return root.val;
    }

    public int countNodes(TreeNode n) {
        if (n == null) return 0;
        return 1 + countNodes(n.left) + countNodes(n.right);
    }

    /**
     * Inorder traverse use recursion.
     */
    private static int count = 0;
    private static int res = 0;
    public static int kthSmallestII(TreeNode root, int k) {
        count = k;
        helper(root);
        return res;
    }
    public static void helper(TreeNode root) {
        if (root == null) return;
        helper(root.left);
        count--;
        if (count == 0) {
            res = root.val;
        }
        helper(root.right);
    }
}

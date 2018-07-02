import java.util.LinkedList;
import java.util.List;

/**
 * Solution: Each time add node val into cur list, and add it to result list if root.val == sum
 *      and root.left and root right is null.
 *      Important: don't forget to new LinkedList when put current list into res
 *      res.add(new LinkedList<>(cur));
 *      And don't each time forget to remove last element after return of each recursion
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class PathSumII {
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new LinkedList<>();
        if (root == null) return res;
        List<Integer> cur = new LinkedList<>();
        checkSum(root, sum, cur, res);
        return res;
    }

    public void checkSum(TreeNode root, int sum, List<Integer> cur, List<List<Integer>> res) {
        if (root == null) return;
        cur.add(root.val);
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                res.add(new LinkedList<>(cur));
            }
        }
        checkSum(root.left, sum - root.val, cur, res);
        checkSum(root.right, sum - root.val, cur, res);
        cur.remove(cur.size() - 1);
    }

    public static void main(String[] args) {
        PathSumII ps = new PathSumII();

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        TreeNode left = root.left;
        left.left = new TreeNode(11);
        TreeNode leftleft = left.left;
        leftleft.left = new TreeNode(7);
        leftleft.right = new TreeNode(2);
        TreeNode right = root.right;
        right.left = new TreeNode(13);
        right.right = new TreeNode(4);
        TreeNode rightright = right.right;
        rightright.left = new TreeNode(5);
        rightright.right = new TreeNode(1);

        System.out.println(ps.pathSumII(root, 22));
    }
}

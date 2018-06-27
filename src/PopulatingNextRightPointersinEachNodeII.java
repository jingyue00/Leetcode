/**
 * Solution: use TreeLinkNode cur, prev and head. the first while loop go through all levels,
 *      the second while loop iterate on the current level. check the prev, is prev == null
 *      let head = current node, else let prev.next = current node, and prev = current node.
 *      use node.next to loop the current level until equals null.
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */
public class PopulatingNextRightPointersinEachNodeII {
    public void connect(TreeLinkNode root) {
        TreeLinkNode cur = root;
        TreeLinkNode prev = null;
        TreeLinkNode head = null;

        while (cur != null) {
            while (cur != null) {       //iterate on the current level
                if (cur.left != null) {
                    if (prev != null) {
                        prev.next = cur.left;
                    } else {
                        head = cur.left;
                    }
                    prev = cur.left;
                }
                if (cur.right != null) {
                    if (prev != null) {
                        prev.next = cur.right;
                    } else {
                        head = cur.right;
                    }
                    prev = cur.right;
                }
                cur = cur.next;
            }
            cur = head;
            prev = null;
            head = null;
        }
    }

    public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
    }
}

/**
 * Requirement: delete a node in the middle
 * Solution: take the node's val and point prev node to next node using .next
 * Time Complexity: O(1)
 * Space Complexity: O(1)
 */
public class DeleteNodeInALinkedList {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

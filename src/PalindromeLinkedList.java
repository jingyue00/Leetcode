/**
 * 234. Palindrome Linked List
 * Given a singly linked list
 * determine if it is a palindrome.
 *
 * Solution: step1. find the midNode, step2. reverse nodes after midNode
 *      step3. use two pointer, one step by one step, check value of each pointer
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class PalindromeLinkedList {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode middleNode = findMiddleNode(head);
        middleNode.next = reverse(middleNode.next);
        while (middleNode.next != null) {
            if (head.val != middleNode.next.val) {
                return false;
            } else {
                head = head.next;
                middleNode = middleNode.next;
            }
        }
        return true;
    }

    private ListNode findMiddleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}

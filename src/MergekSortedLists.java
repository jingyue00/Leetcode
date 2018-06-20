import java.util.PriorityQueue;

/**
 * Solution: to sort array of ListNode, put them in priority queue. Use while loop get the smallest
 *      ListNode and put the next one if not equals to null
 *      Important: make sure check ListNode != null each time
 * Time Complexity: O(nlogn)
 * Space Complexity: O(n)
 */
public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                minHeap.add(lists[i]);
            }
        }
        while (!minHeap.isEmpty()) {
            ListNode min = minHeap.poll();
            ListNode nextNode = min.next;
            if (nextNode != null) {
                minHeap.add(nextNode);
            }
            cur.next = min;
            cur = cur.next;
        }
        return dummy.next;
    }
}

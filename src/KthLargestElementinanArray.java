import java.util.PriorityQueue;

/**
 * Solution: build a k length minHeap. Compare the value and add bigger one into heap.
 * Time Complexity: O(nlogn)
 * Space Complexity: O(k);
 */
public class KthLargestElementinanArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a, b) -> a - b);
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                minHeap.add(nums[i]);
            } else {
                if (nums[i] > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(nums[i]);
                }
            }
        }
        return minHeap.peek();
    }

}

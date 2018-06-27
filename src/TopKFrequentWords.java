import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Solution: first use HashMap to count the frequency, then use minheap to reorder.
 *      After add all elements from HashMap to minHeap, put them into LinkedList and then reverse it.
 *      Important: don't forget to compare first letter use compareTo if the frequency of two word are same.
 * Time Complexity: O(nlogk)
 * Space Complexity: O(n)
 */
public class TopKFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        PriorityQueue<String> minHeap = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) :                                                                               map.get(w1) - map.get(w2));

        for (String word : map.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        List<String> res = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            res.add(minHeap.poll());
        }
        Collections.reverse(res);
        return res;
    }
}

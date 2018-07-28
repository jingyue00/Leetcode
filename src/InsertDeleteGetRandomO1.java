import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * 380. Insert Delete GetRandom O(1)
 * Design a data structure that supports all following operations in average O(1) time.
 * insert(val): Inserts an item val to the set if not already present.
 * remove(val): Removes an item val from the set if present.
 * getRandom: Returns a random element from current set of elements. Each element must have
 * the same probability of being returned.
 *
 * Solution: Use HashMap to record index, in order to get value using index,
 *      we need to use ArrayList to implement List
 * Time Complexity; O(1)
 * Space Complexity: O(n)
 */
public class InsertDeleteGetRandomO1 {
    private Map<Integer, Integer> map;
    private List<Integer> list;
    Random random;
    /** Initialize your data structure here. */
    public InsertDeleteGetRandomO1() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        int index = map.remove(val);
        if (index < list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            map.put(lastVal, index);
            list.set(index, lastVal);
        }
        list.remove(list.size() - 1);
        return true;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}

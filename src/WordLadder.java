import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * 127. Word Ladder
 *
 * Given two words (beginWord and endWord),
 * and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 *
 * Only one letter can be changed at a time
 * Each intermediate word must exist in the word list
 * For example,
 *
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 *
 * Solution: Use set to save wordList, use HashMap to record level, and use queue to get next String
 *      for each word, check its each character with (char c = 'a'; c < 'z'; c++)
 *      Important: don't forget remove string from set after add it to map and queue
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        Map<String, Integer> map = new HashMap<>();
        map.put(beginWord, 1);
        while (!queue.isEmpty()) {
            String cur = queue.poll();
            int level = map.get(cur);
            for (int j = 0; j < cur.length(); j++) {
                char[] array = cur.toCharArray();
                for (char c = 'a'; c < 'z'; c++) {
                    array[j] = c;
                    String tmp = new String(array);
                    if (set.contains(tmp)) {
                        if (tmp.equals(endWord)) {
                            return level + 1;
                        }
                        map.put(tmp, level + 1);
                        set.remove(tmp);
                        queue.offer(tmp);
                    }
                }

            }
        }
        return 0;
    }
}

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * Solution: use HashMap to map the ppid and correspond list of pid. use BFS (queue)
 *      to check each level. Remove current node and add its sub node.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class KillProcess {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < ppid.size(); i++) {
            if (ppid.get(i) > 0) {
                List<Integer> list = mapping.getOrDefault(ppid.get(i), new ArrayList<>());
                list.add(pid.get(i));
                mapping.put(ppid.get(i), list);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new LinkedList<>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int cur = queue.remove();
            res.add(cur);
            if (mapping.containsKey(cur)) {
                for (int id : mapping.get(cur)) {
                    queue.offer(id);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KillProcess kp = new KillProcess();
        List<Integer> pid = new LinkedList<>();
        Collections.addAll(pid, 1,3,10,5);
        List<Integer> ppid = new LinkedList<>();
        Collections.addAll(ppid, 3, 0, 5, 3);
        System.out.println(kp.killProcess(pid,ppid,5));
    }
}

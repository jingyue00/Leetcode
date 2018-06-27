import java.util.LinkedList;
import java.util.List;

/**
 * Solution: begin with the start and end of first intervals, loop each interval in intervals,
 *      if the interval.start < previous end, get the maximum of interval.end and previous end
 *      Else, create the new interval an change previous start and end.
 *      Important: Need to add the final interval after the for loop, because during the loop
 *      we only add the previous interval but not the current one.
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class MergeIntervals {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals.size() <= 1) {
            return intervals;
        }
        List<Interval> res = new LinkedList<>();
        intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
        int curStart = intervals.get(0).start;
        int curEnd = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= curEnd) {
                curEnd = Math.max(interval.end, curEnd);
            } else {
                res.add(new Interval(curStart, curEnd));
                curStart = interval.start;
                curEnd = interval.end;
            }
        }
        res.add(new Interval(curStart, curEnd));
        return res;
    }

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e; }
    }
}

package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** LeetCode 56 - Merge Intervals. Sort by start, then sweep and extend the current interval. O(n log n). */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        int[][] sorted = intervals.clone();
        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> out = new ArrayList<>();
        int[] cur = sorted[0].clone();
        for (int i = 1; i < sorted.length; i++) {
            if (sorted[i][0] <= cur[1]) {
                cur[1] = Math.max(cur[1], sorted[i][1]);
            } else {
                out.add(cur);
                cur = sorted[i].clone();
            }
        }
        out.add(cur);
        return out.toArray(new int[0][]);
    }
}

package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if(intervals.length <= 1) return intervals;

        // Sort by start time

        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];

        merged.add(current);

        // Input: intervals = [[1,4],[4,5]]
        // Output: [[1,5]]

        for(int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];
            if(interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
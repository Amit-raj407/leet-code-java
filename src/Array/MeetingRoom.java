package Array;

import java.util.Arrays;

/**
 * MeetingRoom
 */
public class MeetingRoom {
    public int minMeetingRooms(int[][] intervals) {
        
        int n = intervals.length;
        int maxRooms = 0;

        int[] start = new int[n];
        int[] end = new int[n];

        for(int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int i = 0, j = 0;
        int rooms = 0;

        while(i < n) {
            if(start[i] < end[j]) {
                rooms++;
                maxRooms = Math.max(rooms, maxRooms);
                i++;
            } else {
                rooms--;
                j++;
            }
        }

        return maxRooms;
    }
    
}


/*

Problem

Return the minimum number of meeting rooms required.

Example

Input

[[0,30],[5,10],[15,20]]

Output

2
*/
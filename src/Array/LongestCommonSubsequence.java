package Array;

import java.util.HashSet;
import java.util.Set;

public class LongestCommonSubsequence {
    public int longestChain(int[] nums) {

        // put all in hashset
        Set<Integer> numSet = new HashSet<>();

        for(int num: nums) {
            numSet.add(num);
        }

        int longestStreak = 0;

        for(int num: numSet) {
            if(!numSet.contains(num - 1)) {
                int currentStreak = 1;
                int currentNum = num;

                while(numSet.contains(currentNum + 1)) {
                    currentStreak++;
                    currentNum++;
                }
                longestStreak = Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }
}

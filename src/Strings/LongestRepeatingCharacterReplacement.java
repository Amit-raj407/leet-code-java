package Strings;

public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int maxCount = 0;
        int maxLength = 0;
        int left = 0;

        for(int right = 0; right < s.length(); right++) {
            count[s.charAt(right) - 'A']++;

            maxCount = Math.max(maxCount, count[s.charAt(right) - 'A']);

            // Current window size is (right - left + 1)
            // If valid characters to replace > k, shrink the window from the left

            if((right - left + 1) - maxCount > k) {
                count[s.charAt(left) - 'A']--;
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}


/*

The problem "Longest Repeating Character Replacement" 
(LeetCode 424) is a classic string manipulation problem. 
The goal is to find the length of the longest substring containing the same letter 
after replacing at most $k$ characters.
Here is the most efficient way to solve it using the Sliding Window (Two-Pointer) technique.
The Core LogicInstead of actually replacing characters, we keep track of the frequency 
of the most frequent character currently inside our window.
If the total length of the window minus the frequency of the most frequent character is greater than $k$, 
it means we don't have enough replacements to make the entire window uniform. 
In that case, we shrink the window from the left.Formula:$$\text{Window Length} - \text{Max Frequency} \le k$$If this condition holds, the window is valid.
Java ImplementationSince your environment likely interfaces with Java, here is a clean, optimized solution using an array to track character frequencies.
*/
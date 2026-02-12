package Strings;

//🔴 Problem Statement (LeetCode #3 - Medium)
//        Given a string s, find the length of the longest substring without repeating characters.
//
//        Input: s = "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.



import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class LongestSubStr {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();

        int left = 0;
        int maxLen = 0;

        for(int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            if(map.containsKey(c) && map.get(c) >= left) {
                left = map.get(c) + 1; // move left to skip duplicate
            }

            map.put(c, right);
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

//-------------------------------Dry Run---------------------------------
//        | right | char | map                 | left | window | maxLen |
//        | ----- | ---- | ------------------- | ---- | ------ | ------ |
//        | 0     | 'a'  | a → 0               | 0    | "a"    | 1      |
//        | 1     | 'b'  | a → 0, b → 1        | 0    | "ab"   | 2      |
//        | 2     | 'c'  | a → 0, b → 1, c → 2 | 0    | "abc"  | 3      |
//        | 3     | 'a'  | a → 3, b → 1, c → 2 | 1    | "bca"  | 3      |
//        | 4     | 'b'  | a → 3, b → 4, c → 2 | 2    | "cab"  | 3      |
//        | 5     | 'c'  | a → 3, b → 4, c → 5 | 3    | "abc"  | 3      |
//        | 6     | 'b'  | a → 3, b → 6, c → 5 | 5    | "cb"   | 3      |
//        | 7     | 'b'  | a → 3, b → 7, c → 5 | 7    | "b"    | 3      |




// Brute Force Approach - O(n^2) Time Complexity
//public int lengthOfLongestSubstring(String s) {
//
//    int maxLen = 0;
//
//    for(int i = 0; i < s.length(); i++) {
//        Set<Character> set = new HashSet<>();
//        for(int j = i; j < s.length(); j++) {
//            char c = s.charAt(j);
//            if(set.contains(c)) break;
//            set.add(c);
//            maxLen = Math.max(maxLen, j - i + 1);
//        }
//    }
//    return maxLen;
//
//}
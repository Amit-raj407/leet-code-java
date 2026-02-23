package Array;

import java.util.HashMap;
import java.util.Map;

// Subarray Sum Equals K
public class PrefixSum {

    int prefixSumCount(int[] nums, int k) {
        int count = 0;
        int prefixSum = 0;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        for(int num: nums) {
            prefixSum += num;

            if(map.containsKey(prefixSum - k)) {
                count += map.get(prefixSum - k);
            }
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        
        
        return count;
    }
}

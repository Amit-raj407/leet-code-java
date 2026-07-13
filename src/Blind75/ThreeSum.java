package Blind75;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSum {
     public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> resultSet = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for i
            if( i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1;
            int right = nums.length - 1;

            // nums[i] + nums[left] + nums[right] = 0
            // nums[left] + nums[right] = -nums[i]
            int target = -nums[i];
            while(left < right) {
                int sum = nums[left] + nums[right];
                if(sum == target) {
                    resultSet.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    // Skip duplicates for left and right
                    while(left < right && nums[left] == nums[left + 1]) left++;
                    while(left < right && nums[right] == nums[right - 1]) right--;
                    left++;
                    right--;
                } else if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return resultSet;
    }
}

/*

// better
 Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
              int third = -(nums[i] + nums[j]);

              if(st.contains(third)) {
                List<Integer> temp = Arrays.asList(nums[i], nums[j], third);
                Collections.sort(temp);
                st.add(temp);
              }
            }
        }

        return new ArrayList<>(st);

// brute
public List<List<Integer>> threeSum(int[] nums) {

        Set<List<Integer>> st = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
               for(int k = j + 1; k < nums.length; k++) {
                if(nums[i] + nums[j] + nums[k] == 0) {
                    List<Integer> temp = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(temp);
                        st.add(temp);
                }
               }
            }
        }

        return new ArrayList<>(st);
    }
*/

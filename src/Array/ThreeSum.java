package Array;

import java.util.*;

//Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//Notice that the solution set must not contain duplicate triplets.
//
//
//
//Example 1:
//
//Input: nums = [-1,0,1,2,-1,-4]
//Output: [[-1,-1,2],[-1,0,1]]
//Explanation:
//nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
//nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
//nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
//The distinct triplets are [-1,0,1] and [-1,-1,2].
//Notice that the order of the output and the order of the triplets does not matter.
//Example 2:
//
//Input: nums = [0,1,1]
//Output: []
//Explanation: The only possible triplet does not sum up to 0.
//Example 3:
//
//Input: nums = [0,0,0]
//Output: [[0,0,0]]
//Explanation: The only possible triplet sums up to 0.
//
//
//Constraints:
//
//        3 <= nums.length <= 3000
//        -105 <= nums[i] <= 105

//📈 Time and Space Complexity:
//Complexity	Value
//Time	O(n²)
//Space	O(1) (ignoring output)
//Sorting	O(n log n) upfront

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


// Brute Force Approach - O(n^3) Time Complexity, O(n) Space Complexity
//        Set<List<Integer>> resultSet = new HashSet<>();List<List<Integer>> result= new ArrayList();
//        for(int i = 0; i < nums.length - 2; i++) {
//            for(int j = i + 1; j < nums.length - 1; j++) {
//                for(int k = j + 1; k < nums.length; k++) {
//                    if(nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
//                        Collections.sort(triplet);  // Sort to avoid duplicates like [1,-1,0] vs [-1,0,1]
//                        resultSet.add(triplet);
//                    }
//                }
//            }
//        }
//        return new ArrayList<>(resultSet);

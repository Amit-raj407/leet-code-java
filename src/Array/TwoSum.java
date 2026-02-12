// Efficiently process pairs or groups of elements without nested loops. Great for sorted arrays, partitioning, and in-place operations.
/*
167. Two Sum II - Input Array Is Sorted
Medium

Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order, find two numbers such that they add up to a specific target number. Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.

Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.

The tests are generated such that there is exactly one solution. You may not use the same element twice.

Your solution must use only constant extra space.
*/

package Array;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length;
        j = j - 1;
        int[] result = new int[2];
        int sum = 0;
        while(i < j) {
            sum = numbers[i] + numbers[j];
            if(sum == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if(sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }
}


// Time O(n) - Single pass through the array with two pointers
// Space O(1) - Constant of 2 integers

// Time: O(n^2), Space: O(1)
// Brute Force Approach
//for (int i = 0; i < numbers.length; i++) {
//        for (int j = i + 1; j < numbers.length; j++) {
//        if (numbers[i] + numbers[j] == target)
//        return new int[]{i+1, j+1};
//        }
// }


//HashMap Approach (For Unsorted Arrays)
// Time: O(n), Space: O(n)
//Map<Integer, Integer> map = new HashMap<>();
//for (int i = 0; i < numbers.length; i++) {
//  int complement = target - numbers[i];
//    if (map.containsKey(complement))
//        return new int[]{map.get(complement) + 1, i + 1};
//    map.put(numbers[i], i);
//}

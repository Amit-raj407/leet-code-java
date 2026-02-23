package Array;

public class MaxSumSubArray {
    public int maxSumSubArray(int[] nums, int k) {
        int maxSum = 0;

        // calc first window
        for(int i = 0; i < k; i++ ) {
            maxSum = maxSum + nums[i];
        }

        int windowSum = maxSum;

        for(int i = k; i < nums.length; i++) {
            windowSum = nums[i] + windowSum - nums[i-k];
            maxSum = Math.max(maxSum, windowSum);
        }

        return maxSum;
    }
}
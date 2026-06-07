package Blind75;

public class MaxSubArraySum {
    // Kadane's Algo
    public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            if(sum > maxSum) {
                maxSum = sum;
            }
            if(sum < 0) {
                sum = 0;
            }
        }
        return maxSum;
    }
}



/*
Better - O(n^2)
public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int localSum = 0;
            for(int j = i; j < nums.length; j++) {
                localSum+=nums[j];
                maxSum = Math.max(localSum, maxSum);
            }
        }
        
        return maxSum;
    }


Brute Force - O n^3
public int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for(int i = 0; i < nums.length; i++) {
           
            for(int j = i; j < nums.length; j++) {
                int localSum = 0;
                for (int k = i; k <= j; k++) {
                    localSum += nums[k];
                }
                maxSum = Math.max(maxSum, localSum);
            }
        }
        return maxSum;
    }

*/
package Blind75;

public class MaxProdSubArray {
    public int maxProdSubArray(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        int prefix = 1;
        int suffix = 1;

        for(int i = 0; i < nums.length; i++) {
            if(prefix == 0) prefix = 1;
            if(suffix == 0) suffix = 1;

            prefix = prefix * nums[i];
            suffix = suffix * nums[nums.length - i - 1];
            maxProd = Math.max(maxProd, Math.max(prefix, suffix));
        }

        return maxProd;
    }
}


/*
n^2
 public int maxProdSubArray(int[] nums) {
        int maxProd = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            int prod = 1;
            for(int j = i; j < nums.length; j++) {
                prod*=nums[j];
                maxProd = Math.max(maxProd, prod);     
            }
        }
        return maxProd;
    }


BRUTE - n^3
 int maxProd = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                int prod = 1;
                for(int k = i; k <=j; k++ ) {
                    prod*=nums[k];
                }
                maxProd = Math.max(maxProd, prod); 
            }
        }

        return maxProd;

*/
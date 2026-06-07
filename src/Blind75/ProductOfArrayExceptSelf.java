package Blind75;

public class ProductOfArrayExceptSelf {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int res[] = new int[n];

        // PreCompute left product
        int leftProduct = 1;
        for(int i = 0; i < n; i++) {
            res[i] = leftProduct;
            leftProduct = leftProduct * nums[i];
        }
        // Multiply right side
        int rightProduct = 1;
        for(int i = n - 1; i >= 0; i--) {
            res[i] *= rightProduct;
            rightProduct *= nums[i];
        }
        return res;
    }
}


/*
Brute Force
 public int[] productExceptSelf(int[] nums) {
        int res[] = new int[nums.length];

        for(int i = 0; i < nums.length; i++) {
            int product = 1;
            for(int j = 0; j < nums.length; j++) {
                if(j != i) {
                    product = product * nums[j];
                } 
            }
            res[i] = product;
        }

        return res;
    }
*/
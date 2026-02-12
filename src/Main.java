import Array.TwoSum;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        TwoSum twoSum = new TwoSum();
        System.out.println("Indices found for the target sum." + Arrays.toString(twoSum.twoSum(new int[]{2, 7, 11, 15}, 9)));
    }
}
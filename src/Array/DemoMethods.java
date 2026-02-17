package Array;

import java.util.Arrays;
import java.util.Comparator;

public class DemoMethods {
    public static void main() {
        int[] n = { 0, 1, 6, 2 , 4};
        Arrays.sort(n);
        for(int i: n) {
            System.out.println(i);
        }

        int[][] matrix = {{ 0, 1, 2, 2 , 4}, { 4, 1, 6, 2 , 4}, { 1, 1, 6, 2 , 4}};
        Arrays.sort(matrix, Comparator.comparingInt(a -> a[0]));
        
        Arrays.stream(matrix).flatMapToInt(Arrays::stream)
         .forEach(System.out::print);
    }
}

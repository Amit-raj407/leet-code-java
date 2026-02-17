package Array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        List<Integer> nums = new ArrayList<>();

        nums.add(1);
        nums.add(5);
        nums.add(6);
        nums.add(2);
        nums.add(8);
        nums.add(3);
        nums.add(0);

        nums.sort(Comparator.naturalOrder());

        Collections.sort(nums);


        int key = 5;

        int left = 0;
        int right = nums.size() - 1;

       

        int result = -1;

        while(left <= right) {
            int mid =( left + right) / 2;
            if(nums.get(mid) == key) {
                result = mid;
                break;
            }

            if(key < nums.get(mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}

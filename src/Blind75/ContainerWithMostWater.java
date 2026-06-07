package Blind75;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int maxWater = 0;


        while(left < right) {
            int width = right - left;
            int minHeight = Math.min(height[right], height[left]);

            int area = width * minHeight;

            maxWater = Math.max(maxWater, area);

            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxWater;
    }
}

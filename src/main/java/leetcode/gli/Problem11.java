package leetcode.gli;

public class Problem11 {

    static class Solution {
        public int maxArea(int[] height) {
            int n = height.length;
            int left = 0;
            int right = n - 1;
            int max = 0;

            while (left < right) {
                int currentMax;
                if (height[left] < height[right]) {
                    currentMax = (right - left) * height[left];
                    left++;
                } else {
                    currentMax = (right - left) * height[right];
                    right--;
                }

                if (currentMax > max) {
                    max = currentMax;
                }
            }

            return max;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = new int[] {1, 1};
        System.out.println(solution.maxArea(height));
    }
}

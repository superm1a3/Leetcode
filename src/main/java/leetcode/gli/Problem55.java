package leetcode.gli;

public class Problem55 {

    // WARNING: This solution caused StackOverflowEror
    static class Solution0 {
        public boolean canJump(int[] nums) {
            int n = nums.length;
            return canJump(nums, n-1);
        }

        boolean canJump(int[] nums, int end) {
            if (end == 0) {
                return true;
            }

            for (int i = end - 1; i >= 0; i--) {
                return nums[i] >= end - i && canJump(nums, i);
            }

            return false;
        }
    }

    static class Solution1 {
        public boolean canJump(int[] nums) {
            int leftMostGoodIndex = nums.length - 1;
            for (int i = nums.length - 2; i >= 0; i--) {
                if (nums[i] >= leftMostGoodIndex - i ) {
                    leftMostGoodIndex = i;
                }
            }

            return leftMostGoodIndex == 0;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        System.out.println(solution1.canJump(new int[] {2,3,1,1,4}));
        System.out.println(solution1.canJump(new int[] {3,2,1,0,4}));
        System.out.println(solution1.canJump(new int[] {0}));
    }
}

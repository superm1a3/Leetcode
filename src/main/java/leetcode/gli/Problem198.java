package leetcode.gli;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Problem198 {

    static class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            if (nums.length == 1) {
                return nums[0];
            }

            if (nums.length == 2) {
                return Math.max(nums[0], nums[1]);
            }

            int dp[] = new int[nums.length];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);

            for (int i = 2; i < nums.length; i++) {
                dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
            }

            return dp[nums.length-1];
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{5, 3, 4, 11, 2}));
    }
}

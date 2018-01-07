package leetcode.gli;

public class Problem81 {

    static class Solution {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }
            int lo = 0;
            int hi = nums.length - 1;
            while (lo < hi) {
                // The only line needed compared to _33.java Solution2
                // The solution for Problem 33 doesn't work for the case {1,3,1,1,1},
                // where nums[lo]==nums[mid]==nums[hi]
                while (lo < hi && nums[lo]==nums[hi]) hi--;

                int mid = (lo + hi) / 2;
                if (nums[mid] == target) {
                    return true;
                }

                if (nums[lo] <= nums[mid]) {
                    if (target >= nums[lo] && target < nums[mid]) {
                        hi = mid - 1;
                    } else {
                        lo = mid + 1;
                    }
                } else {
                    if (target > nums[mid] && target <= nums[hi]) {
                        lo = mid + 1;
                    } else {
                        hi = mid - 1;
                    }
                }
            }
            return nums[lo] == target ? true : false;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,3,1,1,1};
        System.out.println(solution.search(nums, 3));
    }
}

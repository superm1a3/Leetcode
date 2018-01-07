package leetcode.gli;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem33 {

    static class Solution {
        public int search(int[] nums, int target) {
            if (nums.length == 0) {
                return -1;
            }

            int low = 0, high = nums.length - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                if (nums[mid] <= nums[high]) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }

            int lowestIndex = low;
            if (target >= nums[lowestIndex] && target <= nums[nums.length-1]) {
                low = lowestIndex;
                high = nums.length - 1;
            } else {
                low = 0;
                high = lowestIndex - 1;
            }

            while (low <= high) {
                int mid = (low + high) / 2;
                if (nums[mid] == target) {
                    return mid;
                } else if (nums[mid] < target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            return -1;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(solution.search(nums, 3));
    }
}

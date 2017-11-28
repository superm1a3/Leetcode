package leetcode.gli;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem1 {

    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            Map<Integer, Integer> map = new HashMap<>();
            int[] result = new int[2];

            for (int i = 0; i < nums.length; i++) {
                int current = nums[i];
                if (map.containsKey(current)) {
                    result[0] = map.get(current);
                    result[1] = i;
                    break;
                }

                map.put(target - current, i);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {2, 7, 11, 15};
        System.out.println(Arrays.toString(solution.twoSum(arr, 9)));
    }
}

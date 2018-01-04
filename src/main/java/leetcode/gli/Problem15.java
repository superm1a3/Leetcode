package leetcode.gli;

import java.util.*;

public class Problem15 {

    // WARNING: This solution is not optimal and may exceed time limit since it uses a Set to avoid duplicates
    static class Solution0 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            Set<List<Integer>> result = new HashSet<>();
            Set<Integer> noDupe = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                int a = nums[i];
                if (!noDupe.contains(a)) {
                    noDupe.add(a);
                    Set<Integer> s = new HashSet<>();
                    for (int j = i + 1; j < nums.length; j++) {
                        // a + nums[j] + any num in s = 0
                        if (s.contains(-a - nums[j])) {
                            result.add(Arrays.asList(a, -a-nums[j], nums[j]));
                        }
                        s.add(nums[j]);
                    }
                }
            }
            return new ArrayList<>(result);
        }
    }

    static class Solution1 {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);

            List<List<Integer>> result = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (i > 0 && nums[i] == nums[i-1]) {
                    continue;
                }

                int target = -nums[i];
                int low = i + 1, high = nums.length - 1;
                while (low < high) {
                    if (nums[low] + nums[high] == target) {
                        result.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while (low < high && nums[low] == nums[low+1]) {
                            low++;
                        }

                        while (low < high && nums[high] == nums[high-1]) {
                            high--;
                        }

                        low++;
                        high--;

                    } else if (nums[low] + nums[high] < target) {
                        low++;
                    } else if (nums[low] + nums[high] > target) {
                        high--;
                    }
                }
            }
            return result;
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution1.threeSum(nums));
        nums = new int[4];
        System.out.println(solution1.threeSum(nums));
    }
}

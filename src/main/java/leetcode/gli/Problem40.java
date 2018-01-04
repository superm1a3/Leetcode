package leetcode.gli;

import java.util.*;

public class Problem40 {

    static class Solution1 {
        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> result = new ArrayList();
            Arrays.sort(candidates);
            backtracking(result, new ArrayList<>(), candidates, 0, target);
            return result;
        }

        void backtracking(List<List<Integer>> result, List<Integer> current, int[] candidates, int start, int target) {
            if (target > 0) {
                for (int i = start; i < candidates.length && candidates[i] <= target; i++) {
                    if (i > start && candidates[i] == candidates[i-1]) {
                        continue;
                    }
                    current.add(candidates[i]);
                    backtracking(result, current, candidates, i + 1, target - candidates[i]);
                    current.remove(current.size() - 1);
                }
            } else if (target == 0) {
                result.add(new ArrayList<>(current));
            }
        }

    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5}; // [1, 1, 2, 5, 6, 7, 10]
        int target = 8;
        System.out.println(solution1.combinationSum2(candidates, target));
    }
}

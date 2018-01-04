package leetcode.gli;

import java.util.ArrayList;
import java.util.List;

public class Problem77 {

    static class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new ArrayList<>();
            int[] numbers = new int[n];
            for (int i = 1; i <= n; i++) {
                numbers[i-1] = i;
            }

            backtracking(result, new ArrayList<Integer>(), numbers, 0, k);

            return result;
        }

        void backtracking(List<List<Integer>> result, List<Integer> current, int[] numbers, int start, int count) {
            if (count <= 0) {
                result.add(new ArrayList<>(current));
            } else {
                for (int i = start; i < numbers.length; i++) {
                    current.add(numbers[i]);
                    backtracking(result, current, numbers, i+1, count-1);
                    current.remove(current.size() - 1);
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.combine(4, 2));
    }
}

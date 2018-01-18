package leetcode.gli;

import com.fishercoder.common.classes.TreeNode;

import java.util.*;

public class Problem120 {

    // Top down
    static class Solution0 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int levels = triangle.size();
            List<Integer> levelSum = new ArrayList<>();

            levelSum.add(triangle.get(0).get(0));
            for (int i = 1; i < levels; i++) {
                List<Integer> temp = new ArrayList<>();
                for (int j = 0; j <= i; j++) {
                    int current = triangle.get(i).get(j);
                    int min = Integer.MAX_VALUE;
                    if (j - 1 >= 0) {
                        min = Math.min(min, current + levelSum.get(j-1));
                    }
                    if (j <= levelSum.size() - 1) {
                        min = Math.min(min, current + levelSum.get(j));
                    }

                    temp.add(min);
                }
                levelSum = temp;
            }

            int result = levelSum.get(0);
            for (int i = 1; i < levels; i++) {
                if (levelSum.get(i) < result) {
                    result = levelSum.get(i);
                }
            }

            return result;
        }
    }

    // Bottom up
    static class Solution1 {
        public int minimumTotal(List<List<Integer>> triangle) {
            int[] levelSum = new int[triangle.size()+1];
            for (int i = triangle.size() - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    levelSum[j] = Math.min(levelSum[j], levelSum[j+1]) + triangle.get(i).get(j);
                }
            }
            return levelSum[0];
        }
    }

    public static void main(String[] args) {
        Solution0 solution0 = new Solution0();
        List<List<Integer>> triangle = new ArrayList<>();
        triangle.add(Arrays.asList(2));
        triangle.add(Arrays.asList(7, 8));
        triangle.add(Arrays.asList(5, 6, 0));
        System.out.println(solution0.minimumTotal(triangle));

        Solution1 solution1 = new Solution1();
        System.out.println(solution1.minimumTotal(triangle));
    }
}

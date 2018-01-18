package leetcode.gli;

import com.fishercoder.common.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem121 {

    static class Solution {
        public int maxProfit(int[] prices) {
            int buy = Integer.MAX_VALUE, maxProfit = 0;
            for (int i = 0; i < prices.length; i++) {
                if (prices[i] < buy) {
                    buy = prices[i];
                } else {
                    maxProfit = Math.max(maxProfit, prices[i] - buy);
                }
            }

            return maxProfit;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}

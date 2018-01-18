package leetcode.gli;

public class Problem122 {

    static class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length <= 1) {
                return 0;
            }

            // The variable buy and the else case is not needed
            int buy = prices[0], maxProfit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] >= prices[i-1]) {
                    maxProfit += prices[i] - prices[i-1];
                } else {
                    buy = prices[i];
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

package leetcode.gli;

import java.util.*;

public class Problem139 {

    static class RandomListNode {
        int label;
        RandomListNode next, random;
        RandomListNode(int x) { this.label = x; }
    };

    // Warning: This solution caused Time Limit Exceeded
    static class Solution0 {
        public boolean wordBreak(String s, List<String> wordDict) {
            return backtrack(s, wordDict);
        }

        boolean backtrack(String s, List<String> wordDict) {
            if (s.length() == 0) {
                return true;
            }

            for (String word : wordDict) {
                if (s.startsWith(word)) {
                    if (backtrack(s.substring(word.length()), wordDict)) {
                        return true;
                    }
                }
            }

            return false;
        }
    }

    static class Solution1 {
        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length()+1];
            dp[0] = true;

            for (int i = 1; i <= s.length(); i++) {
                for (String word : wordDict) {
                    if (i >= word.length()
                            && dp[i - word.length()] == true
                            && word.equals(s.substring(i-word.length(), i))) {
                        dp[i] = true;
                        break;
                    }
                }
            }

            return dp[s.length()];
        }
    }

    public static void main(String[] args) {
        Solution1 solution1 = new Solution1();

        List<String> dict = Arrays.asList("lee", "leet", "code", "tc");
        System.out.println(solution1.wordBreak("leetcode", dict));
    }
}

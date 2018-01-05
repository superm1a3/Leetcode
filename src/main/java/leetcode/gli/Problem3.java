package leetcode.gli;

public class Problem3 {

    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            int len = s.length();
            int max = 0, slow = 0, fast = 0;

            while (fast < len) {
                char c = s.charAt(fast);
                int dupIndex = -1;
                for (int i = slow; i < fast; i++) {
                    if (c == s.charAt(i)) {
                        dupIndex = i;
                        break;
                    }
                }

                if (dupIndex != -1) {
                    slow = dupIndex + 1;
                    dupIndex = -1;
                } else {
                    fast++;
                    max = Math.max(max, fast - slow);
                }
            }

            return max;
        }

        public static void main(String[] args) {
            Solution solution = new Solution();
            System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        }
    }
}

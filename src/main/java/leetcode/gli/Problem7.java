package leetcode.gli;

public class Problem7 {

    static class Solution {
        public int reverse(int x) {
            boolean isNegative = false;
            String s = String.valueOf(x);
            int result = 0;

            if (s.charAt(0) == '-') {
                isNegative = true;
                s = s.substring(1);
            }

            try {
                for (int i = 0, pow = 1; i < s.length(); i++, pow *= 10) {
                    result = Math.addExact(result, Math.multiplyExact(Integer.valueOf(s.substring(i, i+1)), pow));
                }

                if (isNegative) {
                    result = Math.multiplyExact(result, -1);
                }
            } catch (ArithmeticException ex) {
                result = 0;
            }

            return result;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Integer.MAX_VALUE);
        System.out.println(solution.reverse(1534236469));
    }
}

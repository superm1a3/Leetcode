package leetcode.gli;

public class Problem6 {

    static class Solution {
        public String convert(String s, int numRows) {
            int len = s.length();
            int idx = 0;
            StringBuilder[] stringBuilders = new StringBuilder[numRows];
            for (int i = 0; i < numRows; i++) {
                stringBuilders[i] = new StringBuilder();
            }

            while (idx < len) {
                for (int i = 0; i < numRows && idx < len; i++) {
                    stringBuilders[i].append(s.charAt(idx++));
                }

                for (int i = numRows - 2; i > 0 && idx < len; i--) {
                    stringBuilders[i].append(s.charAt(idx++));
                }
            }

            for (int i = 1; i < numRows; i++) {
                stringBuilders[0].append(stringBuilders[i]);
            }

            return stringBuilders[0].toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));

        int idx = 5;
        for (int i = 0; idx < 5; idx++) {
            System.out.println("IN");
        }
    }
}

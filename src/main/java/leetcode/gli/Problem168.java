package leetcode.gli;

public class Problem168 {

    static class Solution {
        public String convertToTitle(int n) {
            int a = n;
            StringBuilder stringBuilder = new StringBuilder();

            while (a != 0) {
                a--;
                stringBuilder.insert(0, indexToChar(a % 26));
                a = a / 26;
            }

            return stringBuilder.toString();
        }

        // 0 -> A; 2 -> B ... ; 25 -> Z
        char indexToChar(int i) {
            return (char)('A' + i);
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.indexToChar(1));
        System.out.println(solution.indexToChar(25));
        System.out.println(solution.convertToTitle(27 * 26 * 26));
    }
}

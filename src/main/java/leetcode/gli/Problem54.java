package leetcode.gli;

import java.util.ArrayList;
import java.util.List;

public class Problem54 {

    static class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> result = new ArrayList<>();

            int m = matrix.length;

            if (m == 0) {
                return result;
            }

            int n = matrix[0].length;

            int left = 0;
            int up = 0;
            int right = n - 1;
            int down = m - 1;

            while (left <= right && up <= down) {
                // left -> right
                for (int i = left; up <= down && i <= right; i++) {
                    result.add(matrix[up][i]);
                }
                up++;

                // up -> down
                for (int i = up; left <= right && i <= down; i++) {
                    result.add(matrix[i][right]);
                }
                right--;

                // right -> left
                for (int i = right; up <= down && i >= left; i--) {
                    result.add(matrix[down][i]);
                }
                down--;

                // down -> up
                for (int i = down; left <= right && i >= up; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

            return result;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{1,2,3}, {4,5,6}, {7,8,9}};
        System.out.println(solution.spiralOrder(matrix));
    }
}

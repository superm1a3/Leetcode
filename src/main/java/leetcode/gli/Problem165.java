package leetcode.gli;

import java.util.Arrays;

public class Problem165 {

    static class Solution1 {
        public int compareVersion(String version1, String version2) {
            String[] v1 = version1.split("\\.");
            String[] v2 = version2.split("\\.");

            int i = 0;
            for (; i < v1.length && i < v2.length; i++) {
                int left = Integer.parseInt(v1[i]);
                int right = Integer.parseInt(v2[i]);

                if (left > right) {
                    return 1;
                } else if (left < right) {
                    return -1;
                }
            }

            if (v1.length == v2.length) {
                return 0;
            } else if (v1.length > v2.length) {
                String rest = String.join("",  Arrays.copyOfRange(v1, i, v1.length));
                return Integer.valueOf(rest).compareTo(Integer.valueOf(0));
            } else {
                String rest = String.join("",  Arrays.copyOfRange(v2, i, v2.length));
                return Integer.valueOf(0).compareTo(Integer.valueOf(rest));
            }
        }
    }

    static class Solution2 {
        public int compareVersion(String version1, String version2) {
            String[] levels1 = version1.split("\\.");
            String[] levels2 = version2.split("\\.");

            int length = Math.max(levels1.length, levels2.length);
            for (int i=0; i<length; i++) {
                Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
                Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
                int compare = v1.compareTo(v2);
                if (compare != 0) {
                    return compare;
                }
            }

            return 0;
        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.compareVersion("1.0", "1"));
        System.out.println(solution.compareVersion("1.1", "1.1.2"));
    }
}

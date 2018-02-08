package leetcode.gli;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;

public class Problem179 {

    static class Solution {
        public String largestNumber(int[] nums) {
            Comparator<String> comparator = (s1, s2) -> (s2+s1).compareTo(s1+s2);

            List<Integer> l = Arrays.stream(nums).boxed().collect(Collectors.toList());
            List<String> strings = l.stream().map(i -> i.toString()).collect(Collectors.toList());
            strings.sort(comparator);

            String val = strings.stream().collect(Collectors.joining());
            String allZero = Stream.generate(() -> "0").limit(val.length()).collect(joining());

            if (allZero.equals(val)) {
                val = "0";
            }

            return val;
        }
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestNumber(new int[]{3, 30, 34, 5, 9}));
        System.out.println(solution.largestNumber(new int[]{121, 12}));
        System.out.println(solution.largestNumber(new int[]{0, 0}));
    }
}

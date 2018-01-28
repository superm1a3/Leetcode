package leetcode.gli;

import java.util.Arrays;

public class Problem0 {

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int[] temp = new int[4];
        System.arraycopy(arr, 1, temp, 2, 2);
        System.out.println(Arrays.toString(temp));

    }
}

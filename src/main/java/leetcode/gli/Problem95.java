package leetcode.gli;

import com.fishercoder.common.classes.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Problem95 {

    static class Solution {
        public List<TreeNode> generateTrees(int n) {
            if (n <= 0) {
                return new ArrayList<TreeNode>();
            }
            return genTreeList(1, n);
        }

        private List<TreeNode> genTreeList (int start, int end) {
            List<TreeNode> list = new ArrayList<TreeNode>();
            if (start > end) {
                list.add(null);
            }
            for(int idx = start; idx <= end; idx++) {
                List<TreeNode> leftList = genTreeList(start, idx - 1);
                List<TreeNode> rightList = genTreeList(idx + 1, end);


//                if (leftList.size() > 1 || rightList.size() > 1) {
//                    System.out.println(leftList.size() + "." + rightList.size());
//                    System.out.println(leftList);
//                    System.out.println(rightList);
//                }

                for (TreeNode left : leftList) {
                    for(TreeNode right: rightList) {
                        TreeNode root = new TreeNode(idx);
                        root.left = left;
                        root.right = right;
                        list.add(root);
                    }
                }
            }
            return list;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateTrees(0));
    }
}

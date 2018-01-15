package leetcode.gli;

import com.fishercoder.common.classes.TreeNode;

import java.util.*;

public class Problem103 {

    static class Solution {
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> result = new ArrayList<>();
            if (root == null) {
                return result;
            }

            Deque<TreeNode> queue = new ArrayDeque<>();
            queue.add(root);

            boolean reverse = false;
            while (!queue.isEmpty()) {
                List<Integer> list = new ArrayList<>();
                List<TreeNode> temp = new ArrayList<>();

                while(!queue.isEmpty()) {
                    TreeNode node = queue.remove();
                    list.add(node.val);
                    if (node.left != null) {
                        temp.add(node.left);
                    }
                    if (node.right != null) {
                        temp.add(node.right);
                    }
                }

                for (TreeNode n : temp) {
                    queue.add(n);
                }

                if (reverse) {
                    Collections.reverse(list);
                    reverse = false;
                } else {
                    reverse = true;
                }

                result.add(list);
            }

            return result;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        TreeNode node1_1 = new TreeNode(9);
        TreeNode node1_2 = new TreeNode(20);
        TreeNode node2_3 = new TreeNode(15);
        TreeNode node2_4 = new TreeNode(7);
        root.left = node1_1;
        root.right = node1_2;
        node1_2.left = node2_3;
        node1_2.right = node2_4;
        System.out.println(solution.zigzagLevelOrder(root));
    }
}
